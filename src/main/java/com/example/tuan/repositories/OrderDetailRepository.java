package com.example.tuan.repositories;

import com.example.tuan.models.OrderDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderDetailRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tuan");

    public void addOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(orderDetail);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public OrderDetail getOrderDetailByOrderAndProduct(long orderId, long productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<OrderDetail> query = entityManager.createQuery(
                "SELECT od FROM OrderDetail od WHERE od.order.order_id = :orderId AND od.product.id = :productId",
                OrderDetail.class
        );
        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);
        OrderDetail orderDetail = query.getSingleResult();
        entityManager.close();
        return orderDetail;
    }

    public List<OrderDetail> getAllOrderDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<OrderDetail> query = entityManager.createQuery("SELECT od FROM OrderDetail od", OrderDetail.class);
        List<OrderDetail> orderDetails = query.getResultList();
        entityManager.close();
        return orderDetails;
    }

    // Add additional methods as needed

    public void updateOrderDetail(OrderDetail orderDetail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(orderDetail);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteOrderDetail(long orderId, long productId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        OrderDetail orderDetail = getOrderDetailByOrderAndProduct(orderId, productId);
        entityManager.remove(orderDetail);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
