package br.com.prodrigues.trabalhopratico.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDao<T> implements IDAO<T> {

    protected EntityManagerFactory factory;
    protected EntityManager em;

    public AbstractDao() {
        factory = Persistence.createEntityManagerFactory("trabalhoPraticoPU");
        em = this.createEntityManager();
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = this.createEntityManager();
        }
        return em;
    }

    private EntityManager createEntityManager() {
        return factory.createEntityManager();
    }

    public void closeEntityManager(EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
        }
    }
}
