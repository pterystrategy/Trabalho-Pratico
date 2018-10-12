package br.com.prodrigues.trabalhopratico.controle;

import br.com.prodrigues.trabalhopratico.dao.IDAO;
import br.com.prodrigues.trabalhopratico.view.IViewCrud;
import java.util.List;




public abstract class AbstractControleSimples<T> implements IControleSimples<T> {

    protected IDAO<T> dao;
    protected IViewCrud<T> crud;
 
    @Override
    public T getAObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.       
    }    

    @Override
    public List<T> getAll() {
        return dao.findAll();
    }
    
    
    
}
