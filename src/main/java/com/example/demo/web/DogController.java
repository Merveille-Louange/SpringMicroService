/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;


import java.util.List;
import org.springframework.http.HttpStatus;
                
/**
 *
 * @author louan
 */

@RestController
public class DogController {

   @Autowired
   private DogService dogService;

    //public void setDogService(DogService dogService) {
        //this.dogService = dogService;
   //}

    @GetMapping("/")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @PostMapping("/add_dog")
    public List<Dog> save(@RequestBody Dog dog){
        dogService.save(dog);
        return dogService.retrieveDogs();
    }
    @DeleteMapping("/dogs/{id}")
    private List<Dog> deleteDog(@PathVariable("id") Long id)
    {
        dogService.delete(id);
        return dogService.retrieveDogs();

    }
//
//    @PostMapping("/books")
//    private int saveDog(@RequestBody Dog dogs)
//    {
//        DogService.saveOrUpdate(dogs);
//        return dogs.getdogid();
//    }
    //creating put mapping that updates the dog detail
    @PutMapping("/books")
    private List<Dog> update(@RequestBody Dog dog)
    {
        dogService.update(dog);
        return dogService.retrieveDogs();
    }
}

