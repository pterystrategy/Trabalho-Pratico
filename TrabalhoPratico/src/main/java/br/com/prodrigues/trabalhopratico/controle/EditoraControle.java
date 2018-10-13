/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.EditoraDao;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.view.gui.grid.EditoraGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.EditoraTela;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EditoraControle extends AbstractControleSimples<Editora> {

    protected EditoraGrid grid;
    private final EditoraTela tela;

    public EditoraControle() {
        this.dao = new EditoraDao();

        this.grid = EditoraGrid.getInstance(null, true, this);
        this.tela = EditoraTela.getInstance(null, true);
    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Editora create() {
        Editora editora = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado() == true) {

                if (!editora.getNamepublisher().isEmpty()) {
                    concluido = true;
                } else {
                    tela.showErrorMessage("Falta Nome");
                    tela.setVisible(true);
                    editora = tela.getScreenObject();
                }
            } else {
                return null;
            }
        } while ((concluido == false) && (tela.isConfirmado() == true));
        return dao.create(editora);
    }

    @Override
    public void read(Editora objeto) {
        List<Editora> findAll = this.dao.findAll();
        String lista = "";
        lista = findAll.stream().map((editora) -> editora.getId() + "\n" + editora.getNamepublisher() + "\n_________-").reduce(lista, String::concat);
        this.tela.showMessage(lista);
    }

    @Override
    public Editora update(Editora objeto) {
        this.read(null);
        long id = tela.askForLong("Digite o código do cliente a editar");
        Editora findById;
        findById = this.dao.findById(id);
        tela.preparaUpdate(findById);
        Editora update = this.tela.update(findById);
        return dao.update(update);
    }

    @Override
    public boolean delete(Editora objeto) {
        this.read(null);
        long askForLong = this.tela.askForLong("Informe o ID: ");
        Editora findById = this.dao.findById(askForLong);
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
