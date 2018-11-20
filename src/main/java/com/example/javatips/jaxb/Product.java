package com.example.javatips.jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "product")
public class Product {

    @XmlAttribute(name = "id")
    private String productId;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "imageUrl")
    private String imageUrl;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "createdBy")
    private User createdBy;

    public Product() {
    }

    public Product(String productId, String description, String imageUrl, BigDecimal price, User createdBy) {
        this.productId = productId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Product{" + "productId='" + productId + '\'' + ", description='" + description + '\'' + ", imageUrl='" + imageUrl + '\'' + ", price="
                + price + ", createdBy=" + createdBy + '}';
    }
}
