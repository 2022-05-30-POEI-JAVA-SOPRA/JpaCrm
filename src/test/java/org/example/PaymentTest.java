package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PaymentTest
{
    @Test
    public void createPayment()
    {
        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        assertTrue( true );
    }

    @Test
    public void findById(){
        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        Payment p2 = PaymentDAO.findById(p.getId());
        assertEquals("La Poste", p2.getBank());
    }

    @Test
    public void findAll() {

        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX-0");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        Payment p1 = new Payment();
        p1.setCardNumber("XXXXXXXXXXXXX-1");
        p1.setBank("La Poste");
        p1.setConfidentialCode("1234");
        PaymentDAO.create(p1);

        Payment p2 = new Payment();
        p2.setCardNumber("XXXXXXXXXXXXX-2");
        p2.setBank("La Poste");
        p2.setConfidentialCode("1234");
        PaymentDAO.create(p2);

        List<Payment> payments = PaymentDAO.findAll();
        assertEquals(3, payments.size());
    }

    @Test
    public void deleteCustomer(){
        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX-0");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        List<Payment> payments = PaymentDAO.findAll();
        assertEquals(1, payments.size());

        PaymentDAO.delete(p);

        payments = PaymentDAO.findAll();
        assertEquals(0, payments.size());
    }

    @Test
    public void updatePayment(){
        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX-0");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        /*****************/

        Payment data = new Payment();
        data.setCardNumber("1234567890");

        PaymentDAO.update(p.getId(), data);

        /*****************/

        Payment updatedPayment = PaymentDAO.findById(p.getId());
        assertEquals("1234567890",updatedPayment.getCardNumber());
    }
}
