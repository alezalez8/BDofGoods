package shunin.org;


import shunin.org.entity.Client;
import shunin.org.entity.Order;
import shunin.org.service.ClientService;
import shunin.org.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    private static final String NAME = "JPAofGoods";


    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        OrderService orderService = new OrderService();
        List<Client> clientList = new ArrayList<>();
        clientList = clientService.getAllClient();
        printToConsole(clientList);
        System.out.println("==============================");

        List<Order> orderList = orderService.getAllOrder();
        printToConsole(orderList);
        System.out.println("==============================");
        System.out.println(clientService.findById(5L));
        System.out.println("==============================");
        Client client = new Client("Test", "One");
        clientService.addClient(client);
        System.out.println("==============================");

    }

    public static <T> void printToConsole(List<T> list) {
        for (T t : list
        ) {
            System.out.println(t);
        }
    }
}
