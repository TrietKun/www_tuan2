package com.example.tuan.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_week2.models.ProductImage;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductImageRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tuan");

    public void addProductImage(ProductImage productImage) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(productImage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ProductImage getProductImageById(long imageId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProductImage productImage = entityManager.find(ProductImage.class, imageId);
        entityManager.close();
        return productImage;
    }

    public List<ProductImage> getAllProductImages() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProductImage> query = entityManager.createQuery("SELECT pi FROM ProductImage pi", ProductImage.class);
        List<ProductImage> productImages = query.getResultList();
        entityManager.close();
        return productImages;
    }

    // Add additional methods as needed

    public void updateProductImage(ProductImage productImage) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(productImage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteProductImage(long imageId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ProductImage productImage = entityManager.find(ProductImage.class, imageId);
        entityManager.remove(productImage);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void close() {
        entityManagerFactory.close();
    }
}
