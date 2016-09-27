package com.springapp.mvc.model;

import javax.persistence.*;

/**
 * Created by sushilmainali on 19/09/2016.
 */

@Entity(name = "location")
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int locationId;

    @Basic
    private String locationName;



    public Location(){}
    public Location(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLovationId(int lovationId) {
        this.locationId = lovationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
