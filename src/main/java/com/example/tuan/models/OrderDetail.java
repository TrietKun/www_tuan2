package com.example.tuan.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "order_details")
public class OrderDetail implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> listProduct;
    private int quantity;
    private double price;
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Order orderId, List<Product> listProduct, int quantity, double price, String note) {
        this.orderId = orderId;
        this.listProduct = listProduct;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", listProduct=" + listProduct +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
