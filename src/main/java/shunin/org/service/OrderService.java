package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Order;
import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;


    public OrderService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;

    }

    public List<Order> getAllOrders() {
        List<Order> orderList;
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        orderList = query.getResultList();
        return orderList;
    }

    public Order findOrderById(Long id) {
        Order order;
        order = entityManager.getReference(Order.class, id);
        if (order == null) {
            System.out.println("Can't find order with id = " + id);
        }
        return order;
    }

    public void deleteOrder(Long id) {
        entityTransaction.begin();
        try {
            Order order = entityManager.getReference(Order.class, id);
            entityManager.remove(order);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            System.out.println("Can't delete this order");
        }

    }

    public void makeOrder(Long clientId, Long... idProducts) {
        List<Products> productsList = new ArrayList<>();
        Client client = entityManager.find(Client.class, clientId);
        for (int i = 0; i < idProducts.length; i++) {
            productsList.add(entityManager.find(Products.class, idProducts[i]));
        }
        Order currentOrder = new Order(client, productsList);
        entityTransaction.begin();
        try {
            entityManager.persist(currentOrder);
            entityTransaction.commit();

        } catch (Exception ex) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new RuntimeException(ex);
        }

    }

    public void getProductsByClientId(Long clientId) {
        List<Products> productsList;
        Client client = entityManager.getReference(Client.class, clientId);
        System.out.println("== You choose client: " + client.getName() + " " + client.getSurename() + " ==");
        List<Order> orderList = client.getOrders();
        for (Order order: orderList
             ) {
            System.out.println("For ORDER # " + order.getOrderId());
            productsList = order.getProductsList();
            for (Products product: productsList
                 ) {
                System.out.println("Title: " + product.getTitle() + ", cost is " + product.getPrice());
            }
        }
    }


}
