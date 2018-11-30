/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.LivroDao;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Classificacao;
import br.com.prodrigues.trabalhopratico.model.Cliente;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.model.Livro;
import br.com.prodrigues.trabalhopratico.modeltable.LivroTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.LivroGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.LivroTela;
import br.com.prodrigues.trabalhopratico.view.html.ClienteHtml;
import br.com.prodrigues.trabalhopratico.view.html.LivroHtml;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prorodrigues
 */
public class LivroControle extends AbstractControleSimples<Livro> {

    private final LivroGrid grid;
    private final LivroTela tela;
    private final LivroTableModel model;
    private final AutorControle autorControle;
    private final EditoraControle editoraControle;

    LivroControle(AutorControle autorControle, EditoraControle editoraControle) {
        this.dao = new LivroDao();
        this.model = new LivroTableModel(this.dao.findAll());
        this.editoraControle = editoraControle;
        this.autorControle = autorControle;
        this.tela = LivroTela.getInstance(null, true);
        //this.grid = LivroGrid.getInstance(null, true, this, model);
        this.grid = new LivroGrid(null, true, this, model);
    }

    @Override
    public void showInicialScreen() {
        this.grid.preparaTela();
    }

    @Override
    public Livro create() {
        boolean concluido = false;
         Livro livro;
        if(preencherCmbs()){
           livro = tela.create(null);
        }else{
            livro = null;
        }
        
        do {
            if (tela.isConfirmado() == true) {
                if (!livro.getTitulo().isEmpty()) {
                    concluido = true;
                } else {
                    tela.showErrorMessage("Falta Nome");
                    tela.setVisible(true);
                    livro = tela.create(livro);
                }
            } else {
                return null;
            }
        } while ((concluido == false) && (tela.isConfirmado() == true));
        livro = dao.create(livro);
        model.add(livro);
        return livro;
    }

    public LivroTableModel getModel() {
        return model;
    }

    @Override
    public void read(Livro objeto) {
        List<Livro> livros = dao.findAll();
        String lista = "";
        lista = livros.stream().map((livro) -> {
            return "Id: "
                    + livro.getId() + ", Nome: "
                    + livro.getTitulo() + ", Data: "
                    + livro.getDataDeLancamento()
                    + "\n";
        }).reduce(lista, String::concat);
        this.tela.showMessage(lista);
    }

    @Override
    public Livro update(Livro objeto) {
//        this.read(null);
//        long id = tela.askForLong("Digite o código do cliente a editar");
        List<Autor> lista = this.autorControle.getAll();
        List<Editora> all = this.editoraControle.getAll();
        tela.setListaAutores(lista);
        tela.setListaEditoras(all);
        this.tela.preparaUpdate(objeto);
        Livro update = tela.update(objeto);
        Livro update1 = dao.update(update);
        this.model.update(objeto, update1);
        return update1;
    }

    @Override
    public boolean delete(Livro objeto) {
//        this.read(null);
//        long askForLong = this.tela.askForLong("Informe o ID: ");
        Livro findById = dao.findById(objeto.getId());
        this.tela.setConfirmado(true);
        boolean delete = this.tela.delete(findById);
        if (delete) {
            this.model.remove(findById);
            return this.dao.delete(findById);
        }
        return false;
    }

    @Override
    public void print() {
       List<Livro> lista = dao.findAll();

        String relatorioHtml = LivroHtml.gerarRelatorio(lista, "Relatório de livros");

        //Salvar em Disco
        FileWriter arquivo;
        try {
            arquivo = new FileWriter("/home/pedro/rlivros.html");
            arquivo.append(relatorioHtml);
            arquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(LivroControle.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("file:///home/pedro/rlivros.html"));
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(LivroControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Abrir em Browser
        //Converter em HTML
    }

    @Override
    public boolean filter(String column, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> getAll() {
        return dao.findAll();
    }

    private List<Classificacao> getClassificacaoAll() {
        return Arrays.asList(Classificacao.values());
    }

    private boolean preencherCmbs() {
        List<Autor> autores = new ArrayList<>();
        
        List<Editora> editoras = new ArrayList<>();
        
        List<Classificacao> classificacoes = this.getClassificacaoAll();
        
        tela.setListaClassificacoes(classificacoes);
        
        if (autores.addAll(this.autorControle.getAll())) {
            tela.setListaAutores(autores);
            if (!editoras.addAll(this.editoraControle.getAll())) {
                tela.showMessage("Deveria cadastrar editoras");
                return false;
            } else {
                tela.setListaEditoras(editoras);
                return true;
            }
        }else {
             tela.showMessage("Deveria cadastrar autores");
             return false;
        }
    }

    public Livro buscaLivro() {
        this.grid.preparaTelaEmprestimo();
        return this.getLivroselecionado();

    }

    private Livro getLivroselecionado() {

        if (grid.isConfirmado()) {
            return model.getObjetoLinha(grid.selectedRow());
        }
        return null;
    }
}
