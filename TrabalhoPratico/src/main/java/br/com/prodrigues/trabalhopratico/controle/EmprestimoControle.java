/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.EmprestimoDao;
import br.com.prodrigues.trabalhopratico.model.Cliente;
import br.com.prodrigues.trabalhopratico.model.Emprestimo;
import br.com.prodrigues.trabalhopratico.model.Livro;
import br.com.prodrigues.trabalhopratico.modeltable.EmprestimoTableModel;
import br.com.prodrigues.trabalhopratico.modeltable.LivroTableModel;
import br.com.prodrigues.trabalhopratico.view.gui.grid.EmprestimoGrid;
import br.com.prodrigues.trabalhopratico.view.gui.tela.EmprestimoTela;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EmprestimoControle extends AbstractControleSimples<Emprestimo> {

    protected EmprestimoGrid grid;
    private final EmprestimoTela tela;
    private final EmprestimoTableModel model;
    private final LivroTableModel livrosModel;
    private final  ClienteControle clienteControle;
    private final  LivroControle livroControle;
    
    public EmprestimoControle(ClienteControle clienteControle, LivroControle livroControle) {
        this.clienteControle = clienteControle;
        this.livroControle = livroControle;
        this.dao = new EmprestimoDao();
        this.model = new EmprestimoTableModel(this.dao.findAll());    
        this.grid = EmprestimoGrid.getInstance(null, true, this, model);
        this.livrosModel = new LivroTableModel(new ArrayList<>());
        this.tela = EmprestimoTela.getInstance(null, true, this.livrosModel, this);
    }
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Emprestimo create() {
        this.preencherCmbs();
        Emprestimo create = tela.create(null);
        boolean concluido = false;

        do {
            if (tela.isConfirmado()) {

                if (!create.getCliente().getName().isEmpty()) {
                    concluido = true;
                } else {
                    tela.setVisible(true);
                    create = tela.create(create);
                }
            } else {
                return null;
            }

        } while ((concluido == false) && (tela.isConfirmado()));
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
                  + emprestimo.getCliente().getName();
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
    
     private void preencherCmbs(){
        List<Cliente> clientes = new ArrayList<>();
        clientes.addAll(this.clienteControle.getAll());
        List<Livro> livros = new ArrayList<>();
        livros.addAll(this.livroControle.getAll());
        tela.setListaClientes(clientes);
        tela.setListaLivros(livros);
    }
    
     public void tabelaLivros(){
         if(this.tela.isConfirmado()){
             List<Livro> showInicialScreen = livroControle.showInicialScreen(this);
             livrosModel.setListaA(showInicialScreen);
         }
     }
}
