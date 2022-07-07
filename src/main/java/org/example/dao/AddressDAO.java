package org.example.dao;

import org.example.entity.Address;
import org.example.entity.Payment;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class AddressDAO {

    public static void create(Address address) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(address);
        tx.commit();
    }

}
