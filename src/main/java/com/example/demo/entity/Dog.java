/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;


import javax.persistence.*;

@Entity
/**
 *
 * @author louan
 */
@Table
public class Dog {
    @Column
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String breed;
    @Column
    private String origin;
   
  public Dog( String name, String breed, String origin) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Dog() {}
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
