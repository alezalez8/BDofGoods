package shunin.org.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class MyCRUD {
    private static final String NAME = "JPAofGoods";

    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(NAME);
    private static EntityManager entityManager = managerFactory.createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }



}
