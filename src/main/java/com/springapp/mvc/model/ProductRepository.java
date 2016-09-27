package com.springapp.mvc.model;

/**
 * Created by sushilmainali on 21/09/2016.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface  ProductRepository  extends JpaRepository<Product,Long> {

    //@Query(value = "select  p.productId from Product p where (p.location.locationId = :locationId)")
    @Query("select p from product p where (p.location.locationId = :locationId)")
    List<Product> findByLocationId(@Param("locationId")int locId);
}
