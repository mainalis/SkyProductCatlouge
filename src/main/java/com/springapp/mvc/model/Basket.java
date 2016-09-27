package com.springapp.mvc.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sushilmainali on 26/09/2016.
 */
@Entity(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    private List<Product> product;



    public Basket(){};

    public Basket(List<Product> product) {
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
