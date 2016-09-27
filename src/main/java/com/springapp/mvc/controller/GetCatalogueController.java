package com.springapp.mvc.controller;

import com.springapp.mvc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.util.List;

/**
 * Created by sushilmainali on 19/09/2016.
 */
@RestController
@RequestMapping("/getCatalogue/*")
public class GetCatalogueController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;


    @RequestMapping(value = "/allProduct", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    @RequestMapping(value= "/productByUserId/{custId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductByCustomerId(@PathVariable("custId") long id) {
        User user = userRepository.findOne(id);
        int locId = user.getUserLocationId().getLocationId();
        List<Product> defaultProduct = productRepository.findByLocationId(1);
        if(locId != 1) {
            List<Product> userLocationProduct = productRepository.findByLocationId(locId);
            defaultProduct.addAll(userLocationProduct);
        }

        if(defaultProduct.size() == 0) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(defaultProduct, HttpStatus.OK);
    }

    @RequestMapping(value= "/productDefault", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductDefault() {

        List<Product> defaultProduct = productRepository.findByLocationId(1);

        if(defaultProduct.size() == 0) {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(defaultProduct, HttpStatus.OK);
    }



    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/basketEntry", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> enterBasket(@RequestParam List<BasketItem> basket,    UriComponentsBuilder ucBuilder) {
        //List<User> userList = userRepository.findAll();
        //return new ResponseEntity<List<User>>(userList, HttpStatus.OK);

        if(basket != null) {

        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(basket.get(0).id).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
