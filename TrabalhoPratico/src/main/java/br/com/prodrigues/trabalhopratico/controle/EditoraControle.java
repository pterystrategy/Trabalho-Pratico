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
/**
 *
 * @author prorodrigues
 */
public class EditoraControle extends AbstractControleSimples<Editora>{

    
    protected EditoraGrid grid;
    private final   EditoraTela tela;

    public EditoraControle() {
        this.dao = new EditoraDao();
        this.tela = EditoraTela.getInstance(null, true);
        this.grid = EditoraGrid.getInstance(null, true, this);
    }
    
    
    
    
    @Override
    public void showInicialScreen() {
        grid.setVisible(true);

    }

    @Override
    public Editora create() {
        Editora editora = tela.create(null);
        boolean concluido = false;
        
        do{
            if(tela.isConfirmado() == true){

                if(! editora.getNamepublisher().isEmpty()){
                    concluido = true;
                }
                else{
                    tela.showErrorMessage("Falta Nome");
                    tela.setVisible(true);
                    editora = tela.getScreenObject();
                }
            }
            
        }while((concluido == false )&& (tela.isConfirmado() == true));

        
      
        return dao.create(editora); 
    }

    @Override
    public void read(Editora objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora update(Editora objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Editora objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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