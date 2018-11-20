package com.example.javatips.jaxb;

import java.io.File;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class ProductToXmlTest {

    private Product product1;
    private Product product2;
    private Products products;

    @Before
    public void setup() {
        User user = new User(1L, "John", "john@example.com");
        product1 = new Product("P01", "Product 01", "http://example.com/product/1", BigDecimal.TEN, user);
        product2 = new Product("P02", "Product 02", "http://example.com/product/2", BigDecimal.ONE, user);
        products = new Products().addProduct(product1).addProduct(product2);
    }

    @Test
    public void testObjectToXml() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(product1, new File("product1.xml"));
        marshaller.marshal(product1, System.out);
    }

    @Test
    public void testXmlToObject() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
        File productFile = new File("product1.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Product product = (Product) unmarshaller.unmarshal(productFile);
        System.out.println(product);
    }

    @Test
    public void testObjectListToXml() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(products, new File("products.xml"));
        marshaller.marshal(products, System.out);
    }

    @Test
    public void testXmlToObjectList() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        File productFile = new File("products.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Products products = (Products) unmarshaller.unmarshal(productFile);
        System.out.println(products);
    }
}
