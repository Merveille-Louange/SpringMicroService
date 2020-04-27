/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;
import com.example.demo.entity.Dog;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 *
 * @author louan
 */
@Service
public interface DogService {
    List<Dog>retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
//    List<Dog> save(Dog dog);
//    void delete(Long id);
//    List<Dog> update(Dog dog);
}
