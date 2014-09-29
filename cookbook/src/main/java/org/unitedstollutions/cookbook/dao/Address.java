package org.unitedstollutions.cookbook.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ruben on 05/08/14.
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String streetAddress;
    private String city;


    private String country;

    public int getId() {
        return id;
    }

}

