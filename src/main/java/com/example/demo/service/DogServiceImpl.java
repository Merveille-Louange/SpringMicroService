/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DogRepository;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author louan
 */
@Service
public class DogServiceImpl implements DogService {

  @Autowired
  DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

    public List<Dog> save(Dog dog){
        dogRepository.insertDog(dog);
        return (List<Dog>) dogRepository.findAll();
    }

//    public void saveOrUpdate(Dog dog)
//    {
//        DogRepository.save(dog);
//    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public List<Dog> delete(Long id)
    {
        dogRepository.deleteById(id);
        return (List<Dog>) dogRepository.findAll();
    }
//    //updating a record
    public List<Dog> update(Dog dog)
    {
        dogRepository.update(dog);
        return (List<Dog>) dogRepository.findAll();
    }
}
