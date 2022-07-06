package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest 
{
    @Test
    public void createCustomer()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        assertTrue( true );
    }

    @Test
    public void findById(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        Customer customer1 = CustomerDAO.findById(customer.getId());
        assertEquals("Alain", customer1.getFirstName());
    }

    @Test
    public void dontFindById() {
        Customer customer = CustomerDAO.findById(5);
        assertNull(customer);
    }
}
