package com.example.tuan.repositories;

import com.example.tuan.Connection.Connection;
import com.example.tuan.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderRepositoty {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tr;
    //private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    public OrderRepositoty(){
        emf = Connection.getInstance().getEmf();
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public void add(Order e){
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }
    public void update(Order e){
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
    }

    public Order findById(long id){
        String sql = "select * from orders where order_id like '"+id+"'";
        Order e = (Order) em.createNativeQuery(sql, Order.class).getSingleResult();
        return e;
    }

    public List<Order> getAll(){
        String sql = "select * from orders";
        List<Order> le = em.createNativeQuery(sql, Order.class).getResultList();
        return le;
    }
}
