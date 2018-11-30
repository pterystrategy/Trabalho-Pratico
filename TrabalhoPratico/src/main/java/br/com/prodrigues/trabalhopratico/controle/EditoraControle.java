/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.EditoraDao;
import br.com.prodrigues.trabalhopratico.model.Editora;
import br.com.prodrigues.trabalhopratico.modeltable.EditoraTableModel;
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
    private final EditoraTableModel model;
    
    private final EnderecoControle enderecoControle;
    
    private TelefoneControle telefoneControle;

    public EditoraControle() {
        this.dao = new EditoraDao();
        this.enderecoControle = new EnderecoControle();
        
        this.model = new EditoraTableModel(this.dao.findAll());

        this.grid = EditoraGrid.getInstance(null, true, this, this.model);
        this.tela = EditoraTela.getInstance(null, true);
    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Editora create() {
        Editora editora = tela.create(null);
        
        if (editora == null) {
            return null;
        }
        else{
            dao.create(editora);
            model.add(editora);
        }
        return editora;
        
//        boolean concluido = false;
//
//        do {
//            if (tela.isConfirmado()) {
//                if (!editora.getNamepublisher().isEmpty()) {
//                   concluido = true;
//                } else {
//                    tela.showErrorMessage("Falta Nome");
//                    editora = tela.create(null);
//                }
//            } else {
//                concluido = false;
//            }
//        } while ((concluido == false) && (tela.isConfirmado() == true)); 
//        editora = dao.create(editora);
//        model.add(editora);
//        return editora;
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
//////        this.read(null);
//        long id = tela.askForLong("Digite o código do cliente a editar");
//        Editora findById;
        this.tela.preparaUpdate(objeto);
        Editora update = tela.update(objeto);
        Editora update1 = dao.update(update);
        this.model.update(objeto, update1);
        return update1;
    }

    @Override
    public boolean delete(Editora objeto) {
//        this.read(null);
//        long askForLong = this.tela.askForLong("Informe o ID: ");
//        Editora findById = this.dao.findById(askForLong);
        Editora findById = dao.findById(objeto.getId());
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
}
