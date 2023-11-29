package com.example.tuan.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "orders")
public class Order {
    //order (order_id, order_date, emp_id, cust_id)
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "order_date")
    private Date orderDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer custId;

    public Order() {
    }

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public Order(Date orderDate, Employee employeeId, Customer custId) {
        this.orderDate = orderDate;
        this.employeeId = employeeId;
        this.custId = custId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    @Override
    public String  toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employeeId=" + employeeId +
                ", custId=" + custId +
                '}';
    }
}
