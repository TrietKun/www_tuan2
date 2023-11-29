package vn.edu.iuh.fit.www_week2.models;

import com.example.tuan.models.Product;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_images")
public class ProductImage implements Serializable {
    //product_image (product_id, image_id, path, alternative)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String path;
    private String alternative;
    public ProductImage() {
    }

    public ProductImage(Product productId, int imageId, String path, String alternative, Product productId1) {
        this.productId = productId;
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
        this.productId = productId1;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "productId=" + productId +
                ", imageId=" + imageId +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", productId=" + productId +
                '}';
    }
}
