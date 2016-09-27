package com.springapp.mvc.model;

import javax.persistence.*;

/**
 * Created by sushilmainali on 19/09/2016.
 */

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Basic
    private String userName;

    @ManyToOne
    private Location userLocation;


    protected User(){}



    public User(String userName, Location userLocation) {

        this.userName = userName;
        this.userLocation = userLocation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getUserLocationId() {
        return userLocation;
    }

    public void setUserLocationId(Location userLocationId) {
        this.userLocation = userLocationId;
    }
}
