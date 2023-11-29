package vn.edu.iuh.fit.www_week2.models;

import com.example.tuan.models.Product;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "product_prices")
public class ProductPrice implements Serializable {
    //product_price (product_id, price_date_time, price, note)
    @Id
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @Column(name = "price_date_time")
    private Date priceDateTime;
    private double price;
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product productId, Date priceDateTime, double price, String note) {
        this.productId = productId;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
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
        return "ProductPrice{" +
                "productId=" + productId +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
