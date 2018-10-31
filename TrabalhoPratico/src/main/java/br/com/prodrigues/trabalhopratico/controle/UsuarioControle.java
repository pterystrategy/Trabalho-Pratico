/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.UsuarioDao;
import br.com.prodrigues.trabalhopratico.model.Usuario;
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

    public UsuarioControle() {
        dao = new UsuarioDao();

        //Cria CRUD
        grid = new UsuarioGrid(null, true, this);

        tela = new UsuarioTela(null, true);

        telaL = LoginTela.getInstance(null, true);

    }

    @Override
    public void showInicialScreen() {
        grid.setVisible(true);
    }

    @Override
    public Usuario create() {
        Usuario usuario = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado()) {
                if (!usuario.getName().isEmpty()) {
                    concluido = true;

                } else {
                    tela.showErrorMessage("Falta nome");
                    tela.setVisible(true);
                    usuario = tela.getScreenObject();
                }
            }

        } while ((concluido == false) && (tela.isConfirmado() == true));
        return dao.create(usuario);
    }

    @Override
    public void read(Usuario objeto) {
        List<Usuario> usuarios = dao.findAll();
        String lista = "";
        for (Usuario usuario : usuarios) {
            lista += "Id: " + usuario.getId() + ", Nome: "
                    + usuario.getName() + ", Login: " + usuario.getLogin() + "\n";

        }
        tela.showMessage(lista);
    }

    @Override
    public Usuario update(Usuario objeto) {
        this.read(null);
        long id = tela.askForLong("Digite o código do funcionário a editar");

        Usuario findById = dao.findById(id);
        tela.preparaUpdate(findById);
        Usuario update = tela.update(findById);
        return dao.update(update);
    }

    @Override
    public boolean delete(Usuario objeto) {
        this.read(null);

        long id = tela.askForLong("Insira o código do usuario a remover");
        Usuario findById = dao.findById(id);
        boolean delete = dao.delete(findById);

        if (delete) {
            tela.showMessage("Usuario excluído com êxito");
        } else {
            tela.showMessage("Usuario não encontrado");
        }
        return delete;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean filter(String column, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showInicialLogin() {
        telaL.setVisible(true);
    }
}
