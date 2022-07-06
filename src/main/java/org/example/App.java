package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;

public class App
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );


        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");

        CustomerDAO.create(customer);

    }
}
