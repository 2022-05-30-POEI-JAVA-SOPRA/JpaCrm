package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void findAll() {

        CustomerDAO.create(new Customer("Marie"));
        CustomerDAO.create(new Customer("Michel"));
        CustomerDAO.create(new Customer("Alex"));

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());
    }

    @Test
    public void deleteCustomer(){
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());

        CustomerDAO.delete(marie);

        customers = CustomerDAO.findAll();
        assertEquals(0, customers.size());
    }

    @Test
    public void deleteCustomerById() {
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.create(michel);
        Customer alex = new Customer("Alex");
        CustomerDAO.create(alex);

        CustomerDAO.deleteCustomerById(michel.getId());

        assertNull(CustomerDAO.findById(michel.getId()));
        assertNotNull(CustomerDAO.findById(marie.getId()));
        assertNotNull(CustomerDAO.findById(alex.getId()));
    }

//    @Test
//    public void deleteCustomerByIdV2() {
//        Customer marie = new Customer("Marie");
//        CustomerDAO.create(marie);
//        Customer michel = new Customer("Michel");
//        CustomerDAO.create(michel);
//        Customer alex = new Customer("Alex");
//        CustomerDAO.create(alex);
//
//        CustomerDAO.deleteCustomerByIdV2(michel.getId());
//
//        assertNull(CustomerDAO.findById(michel.getId()));
//        assertNotNull(CustomerDAO.findById(marie.getId()));
//        assertNotNull(CustomerDAO.findById(alex.getId()));
//    }
}
