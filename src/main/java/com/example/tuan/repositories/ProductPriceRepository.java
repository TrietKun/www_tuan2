package com.example.tuan.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.eclipse.persistence.jpa.jpql.parser.LocalDateTime;
import vn.edu.iuh.fit.www_week2.models.ProductPrice;

import java.util.List;

public class ProductPriceRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tuan");

    public void addProductPrice(ProductPrice productPrice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(productPrice);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ProductPrice getProductPriceByProductIdAndDateTime(long productId, LocalDateTime priceDateTime) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductPrice> query = entityManager.createQuery(
                "SELECT pp FROM ProductPrice pp WHERE pp.product.id = :productId AND pp.price_date_time = :priceDateTime",
                ProductPrice.class
        );
        query.setParameter("productId", productId);
        query.setParameter("priceDateTime", priceDateTime);
        ProductPrice productPrice = query.getSingleResult();
        entityManager.close();
        return productPrice;
    }

    public List<ProductPrice> getAllProductPrices() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductPrice> query = entityManager.createQuery("SELECT pp FROM ProductPrice pp", ProductPrice.class);
        List<ProductPrice> productPrices = query.getResultList();
        entityManager.close();
        return productPrices;
    }

    // Add additional methods as needed

    public void updateProductPrice(ProductPrice productPrice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(productPrice);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteProductPrice(long productId, LocalDateTime priceDateTime) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ProductPrice productPrice = getProductPriceByProductIdAndDateTime(productId, priceDateTime);
        entityManager.remove(productPrice);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
