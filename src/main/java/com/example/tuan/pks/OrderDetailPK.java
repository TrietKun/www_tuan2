package com.example.tuan.pks;


import com.example.tuan.models.Order;
import com.example.tuan.models.Product;

import java.io.Serializable;


public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;

    @Override
    public String toString() {
        return "OrderDetailPK{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderDetailPK() {
    }

    public OrderDetailPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
