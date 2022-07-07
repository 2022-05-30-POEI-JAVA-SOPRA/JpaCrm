package org.example.dao;

import org.example.entity.Address;
import org.example.entity.Product;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductDAO {

    public static void create(Product product) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(product);
        tx.commit();
    }

}
