package shunin.org.service;

import shunin.org.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends MyCRUD{

    EntityManager entityManager = getEntityManager();

    public List<Client> getAllClient() {
        List<Client> clientList = new ArrayList<>();

        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        clientList = query.getResultList();
        return clientList;



    }
}
