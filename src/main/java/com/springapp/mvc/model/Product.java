package com.springapp.mvc.model;

import com.springapp.mvc.Enum.ProductType;

import javax.persistence.*;

/**
 * Created by sushilmainali on 19/09/2016.
 */

@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Basic
    private String productName;


    @Basic
    private ProductType productType;


    @ManyToOne
    private Location location;


    protected Product() {}

    public Product(String productName, ProductType productType, Location mLocation) {

        this.productName = productName;
        this.productType = productType;
        this.location = mLocation;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
