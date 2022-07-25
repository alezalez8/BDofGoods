package shunin.org;


import shunin.org.entity.Client;
import shunin.org.service.ClientService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Starter {
    private static final String NAME = "JPAofGoods";



    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        List<Client> clientList = new ArrayList<>();
        clientList = clientService.getAllClient();
        for (Client client :clientList
        ) {
            System.out.println(client);
        }


    }
}
