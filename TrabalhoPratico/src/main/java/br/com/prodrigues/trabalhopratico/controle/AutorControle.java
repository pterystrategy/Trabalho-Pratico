/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.AutorDao;
import br.com.prodrigues.trabalhopratico.model.Autor;
import br.com.prodrigues.trabalhopratico.modeltable.AutorTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.AutorGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.AutorTela;
/**
 * @author prorodrigues
 */
public class AutorControle extends AbstractControleSimples<Autor> {
    protected AutorGrid grid;
    private final AutorTela tela;
    private final AutorTableModel model;
    public AutorControle() {
        this.dao = new AutorDao();
        this.model = new AutorTableModel(this.dao.findAll());
        this.grid = AutorGrid.getInstance(null, true, this, model);
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
            if (tela.isConfirmado()) {
                if (!autor.getName().isEmpty()) {
                    concluido = true;
                } else {
                    tela.showErrorMessage("Falta Nome");
                    autor = tela.create(autor);
                }
            } else {
                return null;
            }

        } while ((concluido == false) && (tela.isConfirmado() == true));
        autor = dao.create(autor);
        model.add(autor);
        return autor;
    }

    @Override
    public void read(Autor objeto) {
       tela.read(objeto);
    }

    @Override
    public Autor update(Autor objeto) {
        this.tela.preparaUpdate(objeto);
        Autor update = tela.update(objeto);
        Autor update1 = dao.update(update);
        this.model.update(objeto, update1);
        return update1;
    }

    @Override
    public boolean delete(Autor objeto) {
        Autor findById = dao.findById(objeto.getId());
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

}
