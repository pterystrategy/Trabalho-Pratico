/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Editora;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class EditoraDao extends AbstractDao<Editora>{

    @Override
    public Editora create(Editora entity) {
        em.getTransaction().begin();
        em.persist(entity);
//        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);

        return entity;
    }

    @Override
    public boolean delete(Editora entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora update(Editora entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Editora findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Editora> find(Editora entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Editora> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
