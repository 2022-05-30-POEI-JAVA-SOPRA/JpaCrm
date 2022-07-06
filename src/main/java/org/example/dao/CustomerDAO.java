package org.example.dao;

import org.example.entity.Customer;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerDAO {

    public static void create(Customer customerToCreate) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(customerToCreate);
        tx.commit();
    }
}
