package com.example.javatips.jaxb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "products")
public class Products {


    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @XmlElement(name = "product")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Products addProduct(Product product) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(product);
        return this;
    }

    @Override
    public String toString() {
        return "Products{" + "products=" + products + '}';
    }
}
