package com.recipetracker.finalversionrecipetracker.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Recipe recipe;
}