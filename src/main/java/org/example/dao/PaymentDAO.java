package org.example.dao;

import org.example.entity.Customer;
import org.example.entity.Payment;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PaymentDAO {

    public static void create(Payment payment) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(payment);
        tx.commit();
    }

    public static Payment findById(long id) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment payment = entityManager.find(Payment.class, id);

        return payment;
    }

    public static List<Payment> findAll() {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Query findAllQuery = entityManager.createQuery("select p from Payment p");
        return findAllQuery.getResultList();
    }

    public static void delete(Payment payment) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(payment);
        tx.commit();
    }

    public static void deleteById(Long id) {
        Payment p = findById(id);
        delete(p);
    }

    public static void update(Long id, Payment data) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Payment paymentToUpdate = entityManager.find(Payment.class, id);
        paymentToUpdate.setNotNullData(data);

        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(paymentToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}
