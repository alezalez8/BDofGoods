package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderService  extends MyCRUD{
    EntityManager entityManager = getEntityManager();


    public List<Order> getAllOrder() {

        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        List<Order> orderList = query.getResultList();
        return orderList;

    }
}
