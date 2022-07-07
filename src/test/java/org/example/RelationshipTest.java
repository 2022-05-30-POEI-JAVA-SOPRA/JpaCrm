package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Test;

import static org.junit.Assert.*;

public class RelationshipTest
{
    @Test
    public void oneToOne()
    {
        Payment p = new Payment();
        p.setCardNumber("XXXXXXXXXXXXX");
        p.setBank("La Poste");
        p.setConfidentialCode("1234");
        PaymentDAO.create(p);

        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setPayment(p);
        CustomerDAO.create(customer);


        /**************/

        Customer c = CustomerDAO.findById(customer.getId());
        System.out.println(c.getPayment().getCardNumber());
        assertNotNull( c.getPayment() );
    }

}
