/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entity.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 * @author louan
 */
@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
     @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();


    @Modifying
    @Query(value = "insert into Dog (name, breed, origin) VALUES (dog.name, dog.breed, dog.origin)", nativeQuery = true)
    List<Dog> insertDog(@Param("dog") Dog dog);


   @Query("DELETE FROM Dog d WHERE d.id=:id")
   void deleteById(Long id);
//
    
    @Query("UPDATE Dog SET name = dog.name, breed = dog.breed, origin=dog.origin WHERE dog.id=:id")
    List<Dog> update(@Param("dog") Dog dog) ;
//
//    @Query(" INSERT INTO Dog (id, name, breed,origin) VALUES (d.id, d.name, d.breed,d.origin)")
//    void save(Dog dog);

    }

    

