package com.springapp.mvc.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sushilmainali on 20/09/2016.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
