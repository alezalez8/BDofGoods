package shunin.org.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class MyCRUD {
    private static final String NAME = "JPAofGoods";

    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(NAME);
    private static EntityManager entityManager = managerFactory.createEntityManager();
    private static EntityTransaction entityTransaction;

    protected EntityManager getEntityManager() {
        return entityManager;
    }
    protected EntityTransaction getEntityTransaction() {
        return entityManager.getTransaction();
    }





}
