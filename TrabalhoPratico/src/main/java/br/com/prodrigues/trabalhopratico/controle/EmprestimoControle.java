/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.EmprestimoDao;
import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import br.com.prodrigues.trabalhopratico.modeltable.EmprestimoTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.EmprestimoGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.EmprestimoTela;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoControle extends AbstractControleSimples<Emprestimo> {

    protected EmprestimoGrid grid;
    private final EmprestimoTela tela;
    private final EmprestimoTableModel model;
    private  ClienteControle clienteControle;
    private  LivroControle livroControle;
    
    public EmprestimoControle() {
        this.dao = new EmprestimoDao();
        this.model = new EmprestimoTableModel(this.dao.findAll());

        this.grid = EmprestimoGrid.getInstance(null, true, this, model);
        this.tela = EmprestimoTela.getInstance(null, true);

    }

    public EmprestimoControle(ClienteControle clienteControle, LivroControle livroControle) {
        this();
        this.clienteControle = clienteControle;
        this.livroControle = livroControle;
    }
    
    
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Emprestimo create() {
        Emprestimo create = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado() == true) {

                if (!create.getCliente().getName().isEmpty()) {
                    concluido = true;
                } else {
                    tela.setVisible(true);
                    create = tela.getScreenObject();
                }
            } else {
                return null;
            }

        } while ((concluido == false) && (tela.isConfirmado() == true));
        Emprestimo createD = dao.create(create);
        model.add(createD);
        return createD;
    }

    @Override
    public void read(Emprestimo objeto) {
        List<Emprestimo> findAll = dao.findAll();
        String lista = "";
        for (Emprestimo emprestimo : findAll) {
            lista +="ID: "+ emprestimo.getId() + "Nome do Cliente: " 
                  + emprestimo.getCliente().getName() 
                  + "Nome do livro: " + emprestimo.getLivro().getTitulo() + "\n";
        }
        this.tela.showMessage(lista);
    }

    @Override
    public Emprestimo update(Emprestimo objeto) {
        this.tela.preparaUpdate(objeto);
        Emprestimo update = tela.update(objeto);
        Emprestimo update1 = dao.update(update);
        this.model.update(objeto, update1);
        return update1;
    }

    @Override
    public boolean delete(Emprestimo objeto) {
        Emprestimo findById = dao.findById(objeto.getId());
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
