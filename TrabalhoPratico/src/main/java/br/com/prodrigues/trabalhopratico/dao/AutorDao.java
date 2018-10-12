/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Autor;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author prorodrigues
 */
public class AutorDao extends AbstractDao<Autor> {

    @Override
    public Autor create(Autor entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);

        return entity;
    }

    @Override
    public boolean delete(Autor entity) {
        em.getTransaction().begin();
        Autor autor;
        autor = em.getReference(Autor.class, entity.getId());

        if (entity.equals(autor)) {
            em.remove(autor);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Autor update(Autor entity) {
        em.getTransaction().begin();
        Autor merge = this.getEntityManager().merge(entity);
        
        em.getTransaction().commit();
        
        return merge;
    }    

    @Override
    public Autor findById(int id) {
        return this.findById((long)id);
    }

    @Override
    public Autor findById(long id) {
        Autor item = em.find(Autor.class, id);
        return item;
    }

    @Override
    public List<Autor> find(Autor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> findAll() {
        CriteriaQuery cq;
        cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Autor.class));
        return em.createQuery(cq).getResultList();
      }
}
