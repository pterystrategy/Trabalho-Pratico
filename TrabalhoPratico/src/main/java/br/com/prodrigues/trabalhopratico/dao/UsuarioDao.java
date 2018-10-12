package br.com.prodrigues.trabalhopratico.dao;

import br.com.prodrigues.trabalhopratico.model.Usuario;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

public class UsuarioDao extends AbstractDao<Usuario> {

    @Override
    public Usuario create(Usuario entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        em.refresh(entity);
        return entity;
    }

    @Override
    public boolean delete(Usuario entity) {
        em.getTransaction().begin();
        Usuario usuario;
        usuario = em.getReference(Usuario.class, entity.getId());
        
        if (usuario.equals(entity)) {
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Usuario update(Usuario entity) {
        em.getTransaction().begin();
        Usuario merge = this.getEntityManager().merge(entity);
        
        em.getTransaction().commit();
        return merge;
    }

    @Override
    public Usuario findById(int id) {
        return this.findById((long)id);
    }

    @Override
    public Usuario findById(long id) {
        return this.em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> find(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findAll() {
        CriteriaQuery cq;
        cq = this.em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Usuario.class));
        return this.em.createQuery(cq).getResultList();      
    }
}