/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.LivroDao;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Classificacao;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.model.Livro;
import br.com.prodrigues.trabalhopratico.modeltable.LivroTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.LivroGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.LivroTela;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class LivroControle extends AbstractControleSimples<Livro> {

    private final LivroGrid grid;
    private final LivroTela tela;
    private LivroTableModel model;
    private final AutorControle autorControle;
    private EditoraControle editoraControle;

    public LivroControle(AutorControle autorControle) {
        this.dao = new LivroDao();
        this.autorControle = autorControle;
        this.model = new LivroTableModel(this.dao.findAll());

        this.grid = LivroGrid.getInstance(null, true, this, model);
        this.tela = LivroTela.getInstance(null, true);
    }

    LivroControle(AutorControle autorControle, EditoraControle editoraControle) {
        this(autorControle);
        this.editoraControle = editoraControle;
    }

    @Override
    public void showInicialScreen() {
        this.grid.setVisible(true);
    }

    @Override
    public Livro create() {
        boolean concluido = false;
        preencherCmbs();
        Livro livro = tela.create(null);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    private void preencherCmbs(){
        List<Autor> autores = new ArrayList<>();
        autores.addAll(this.autorControle.getAll());
        List<Editora> editoras = new ArrayList<>();
        editoras.addAll(this.editoraControle.getAll());
        List<Classificacao> classificacoes = this.getClassificacaoAll();
        tela.setListaEditoras(editoras);
        tela.setListaAutores(autores);
        tela.setListaClassificacoes(classificacoes);
    }
}
