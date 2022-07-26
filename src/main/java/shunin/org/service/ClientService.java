package shunin.org.service;

import shunin.org.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends MyCRUD{

    EntityManager entityManager = getEntityManager();
    EntityTransaction entityTransaction = getEntityTransaction();


    public List<Client> getAllClient() {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
         List<Client>  clientList = query.getResultList();
        return clientList;
    }

    public void addClient(Client client) {
        entityTransaction.begin();

        entityManager.persist(client);
        entityTransaction.commit();

    }

    public Client findById(Long id) {
        return   entityManager.find(Client.class, id);
    }


}
