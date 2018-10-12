/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Livro;
import java.util.List;

/**
 *
 * @author prorodrigues
 */
public class LivroDao extends AbstractDao<Livro> {

    @Override
    public Livro create(Livro entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);

        return entity;
    }

    @Override
    public boolean delete(Livro entity) {
         em.getTransaction().begin();
        Livro reference = em.getReference(Livro.class, entity.getId());

        if (entity.equals(reference)) {
            em.remove(reference);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Livro update(Livro entity) {
        em.getTransaction().begin();
        Livro merge = this.getEntityManager().merge(entity);
        
        em.getTransaction().commit();
        
        return merge;
    }

    @Override
    public Livro findById(int id) {
        return this.findById((long)id);

    }

    @Override
    public Livro findById(long id) {
        Livro item = em.find(Livro.class, id);
        return item;
    }

    @Override
    public List<Livro> find(Livro entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Livro> findAll() {
        javax.persistence.criteria.CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Livro.class));
        return em.createQuery(cq).getResultList();
    }

}
