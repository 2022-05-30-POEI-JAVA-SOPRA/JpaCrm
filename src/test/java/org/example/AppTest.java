package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.example.util.Gender;
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
    public void createCustomerWithGender()
    {
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setGender(Gender.OTHER);

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

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setAddress("rue de la mairie");
        customer.setCity("Paris");
        customer.setCompanyName("Google");
        customer.setCountry("France");
        customer.setEmail("alain@delon.fr");
        customer.setPhone("060606060606");
        customer.setZipCode("75000");
        customer.setState(1);
        CustomerDAO.create(customer);

        /*****************/

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("Jean-Paul");
        newCustomerData.setLastName("Belmondo");

        CustomerDAO.update(customer.getId(), newCustomerData);

        /*****************/

        Customer updatedCustomer = CustomerDAO.findById(customer.getId());
        assertEquals("Jean-Paul", updatedCustomer.getFirstName());
        assertEquals("Belmondo", updatedCustomer.getLastName());

    }

    @Test
    public void selectWhere(){
        Customer customer1 = new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        CustomerDAO.create(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alain");
        customer2.setLastName("Prost");
        CustomerDAO.create(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Marie");
        customer3.setLastName("Dupont");
        CustomerDAO.create(customer3);

        /*****************/

        List<Customer> alains = CustomerDAO.findByFirstName("Alain");

        /*****************/

        assertEquals(2, alains.size());

        for(Customer c : alains){
            if(! c.getFirstName().equals("Alain")){
                assertTrue(false);
            }
        }
    }
}
