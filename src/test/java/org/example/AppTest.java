package org.example;

import static org.junit.Assert.assertTrue;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;

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

}
