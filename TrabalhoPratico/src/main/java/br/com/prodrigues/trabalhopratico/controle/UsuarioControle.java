/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.UsuarioDao;
import br.com.prodrigues.trabalhopratico.model.Usuario;
import br.com.prodrigues.trabalhopratico.modeltable.UsuarioTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.UsuarioGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.LoginTela;
import br.com.prodrigues.trabalhopratico.view.gui.tela.UsuarioTela;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class UsuarioControle extends AbstractControleSimples<Usuario> {

    protected UsuarioGrid grid;
    private final UsuarioTela tela;
    private final LoginTela telaL;
    private final UsuarioTableModel model;

    public UsuarioControle() {
        dao = new UsuarioDao();

        this.model = new UsuarioTableModel(this.dao.findAll());

        //Cria CRUD
        grid = UsuarioGrid.getInstance(null, true, this, this.model);

        this.tela = UsuarioTela.getInstance(null, true);

        telaL = LoginTela.getInstance(null, true);

    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Usuario create() {
        Usuario usuario = tela.create(null);
        
        if (tela.isConfirmado() == false) {
            return null;
        }
        else{
            dao.create(usuario);
            model.add(usuario);
        }
        return usuario;
    }

    @Override
    public void read(Usuario objeto) {
        tela.read(objeto);
    }

    @Override
    public Usuario update(Usuario objeto) {
        
        this.tela.preparaUpdate(objeto);
        Usuario update = tela.update(objeto);
        Usuario updateDao = dao.update(update);
        this.model.update(objeto, updateDao);
        return updateDao;
    }

    @Override
    public boolean delete(Usuario objeto) {
//        this.read(null);
//
//        long id = tela.askForLong("Insira o código do usuario a remover");
        Usuario findById = dao.findById(objeto.getId());
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
    
    public boolean showInicialLogin() {
        
       return logar();
    }
    
    private boolean logar(){
        telaL.setVisible(true);
        //telaL.preparaLogin();
        
        if (telaL.isConfirmado()){
            Usuario screenObject = telaL.getScreenObject();
            return screenObject.getLogin().equals("admin") && screenObject.getSenha().equals("123");
        }
        else{
            return false;
        }
}
}
