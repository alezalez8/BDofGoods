package shunin.org;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Starter {
    private static final String NAME = "JPAofGoods";

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(NAME);
    private EntityManager entityManager;

    public static void main(String[] args) {

        try {
         //    entityManager = entityManagerFactory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
