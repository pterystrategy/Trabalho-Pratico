/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.LivroDao;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.model.Livro;
import br.com.prodrigues.trabalhopratico.view.gui.grid.LivroGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.LivroTela;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class LivroControle extends AbstractControleSimples<Livro> {

    private final LivroGrid grid;
    private final LivroTela tela;
    private final AutorControle autorControle;

    public LivroControle(AutorControle autorControle) {
        this.dao = new LivroDao();
        this.autorControle = autorControle;
        this.grid = LivroGrid.getInstance(null, true, this);
        this.tela = LivroTela.getInstance(null, true);
    }

    @Override
    public void showInicialScreen() {
        this.grid.setVisible(true);
    }

    @Override
    public Livro create() {
        Livro livro;
        List<Autor> lista = this.autorControle.getAll();

        tela.setListaAutores(lista);
        livro = tela.create(null);

        return dao.create(livro);
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
        tela.showMessage(lista);
    }

    @Override
    public Livro update(Livro objeto) {
        this.read(null);
        long id = tela.askForLong("Digite o código do cliente a editar");
        List<Autor> lista = this.autorControle.getAll();
        tela.setListaAutores(lista);
        Livro findById = dao.findById(id);
        tela.preparaUpdate(findById);
        Livro update = tela.update(findById);
        return dao.update(update);
    }

    @Override
    public boolean delete(Livro objeto) {
        this.read(null);
        long askForLong = this.tela.askForLong("Informe o ID: ");
        Livro findById = dao.findById(askForLong);
        boolean delete = this.tela.delete(findById);
        if (delete) {
            return this.dao.delete(findById);
        }
        return  false;
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

}
