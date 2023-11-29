package com.example.tuan.repositories;

import com.example.tuan.enums.EmployeeStatus;
import com.example.tuan.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction tr;
    //private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository(){
        em= Persistence.createEntityManagerFactory("tuan").createEntityManager();
        tr= em.getTransaction();
    }

    public void add(Employee e){
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

    public void setStatus(Employee e, EmployeeStatus es){
        e.setStatus(es);
    }

    public void update(Employee e){
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

    public Employee findById(long id){
        String sql = "select * from employees where emp_id like '"+id+"'";
        Employee e = (Employee) em.createNativeQuery(sql, Employee.class).getSingleResult();
        return e;
    }

    public List<Employee> getAll(){
        String sql = "select * from employees";
        List<Employee> le = em.createNativeQuery(sql, Employee.class).getResultList();
        return le;
    }
}
