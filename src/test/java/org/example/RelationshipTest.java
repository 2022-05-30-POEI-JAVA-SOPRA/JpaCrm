package org.example;

import org.example.dao.AddressDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDAO;
import org.example.dao.ProductDAO;
import org.example.entity.Address;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.example.entity.Product;
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

    @Test
    public void manyToOne()
    {
        Address adresse1 = new Address();
        adresse1.setStreet("Rue du vieuxport");
        adresse1.setCity("Marseille");
        adresse1.setCountry("France");
        adresse1.setZipCode("13000");
        AddressDAO.create(adresse1);

        Customer alain = new Customer();
        alain.setFirstName("Alain");
        alain.setLastName("Delon");
        alain.setDeliveryAddress(adresse1);
        CustomerDAO.create(alain);

        Customer brigitte = new Customer();
        brigitte.setFirstName("Brigitte");
        brigitte.setLastName("Delon");
        brigitte.setDeliveryAddress(adresse1);
        CustomerDAO.create(brigitte);
    }

    @Test
    public void manyToMany(){
        Product ipad = new Product("iPad", "version 2018 - 11 pouces", 500);
        ProductDAO.create(ipad);
        Product gourde = new Product("gourde", "1,2 L", 15);
        ProductDAO.create(gourde);

        Customer alain = new Customer();
        alain.setFirstName("Alain");
        alain.setLastName("Delon");
        alain.addProduct(ipad);
        alain.addProduct(gourde);
        CustomerDAO.create(alain);

        Customer brigitte = new Customer();
        brigitte.setFirstName("Brigitte");
        brigitte.setLastName("Delon");
        brigitte.addProduct(ipad);
        brigitte.addProduct(gourde);
        CustomerDAO.create(brigitte);

        /************************/

        for(Product product : brigitte.getProducts()){
            System.out.println(product);
        }

    }
}
