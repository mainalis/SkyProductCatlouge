package com.springapp.mvc.controller;


import com.springapp.mvc.model.BasketItem;
import com.springapp.mvc.model.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by sushilmainali on 26/09/2016.
 */

@Controller
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @RequestMapping(value ="/getBasket", method = RequestMethod.GET)
    public String displayBasket(ModelMap model) {
        return "basket";
    }



}
