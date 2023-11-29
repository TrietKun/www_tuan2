package com.example.tuan.Connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static Connection instance;
    private EntityManagerFactory emf;
    private Connection(){
        emf= Persistence.createEntityManagerFactory("tuan2");
    }
    public static Connection getInstance(){
        if (instance==null)
            instance= new Connection();
        return instance;
    }
    public EntityManagerFactory getEmf(){
        return emf;
    }
}
