/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.AutorDao;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.view.gui.grid.AutorGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.AutorTela;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class AutorControle extends AbstractControleSimples<Autor> {

    protected AutorGrid grid;
    private final AutorTela tela;

    public AutorControle() {
        this.dao = new AutorDao();

        this.grid = AutorGrid.getInstance(null, true, this);
        this.tela = AutorTela.getInstance(null, true);

    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Autor create() {
        Autor autor = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado() == true) {

                if (!autor.getName().isEmpty()) {
                    concluido = true;
                } else {
                    tela.showErrorMessage("Falta Nome");
                    tela.setVisible(true);
                    autor = tela.getScreenObject();
                }
            } else {
                return null;
            }

        } while ((concluido == false) && (tela.isConfirmado() == true));

        return dao.create(autor);
    }

    @Override
    public void read(Autor objeto) {
        List<Autor> findAll = dao.findAll();
        String lista = "";
        lista = findAll.stream().map((autor) -> autor.getId()
                + "\n" + autor.getName() + "\n\n"
                + autor.getNascimento() + "\n").reduce(lista, String::concat);
        this.tela.showMessage(lista);
    }

    @Override
    public Autor update(Autor objeto) {
        this.read(null);
        long id = tela.askForLong("Digite o código do autor a editar");

        Autor findById = dao.findById(id);
        tela.preparaUpdate(findById);
        Autor update = tela.update(findById);
        return dao.update(update);
    }

    @Override
    public boolean delete(Autor objeto) {
        this.read(null);
        long askForLong = this.tela.askForLong("Informe o ID: ");
        Autor findById = dao.findById(askForLong);
        boolean delete = this.tela.delete(findById);
        if (delete) {
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

}
