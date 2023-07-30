package com.proyectos.pokeAPI.services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PokeAPIService<T> {

     List<T> findAll();

     T findById(Integer id);

     T findByName(String name);

}
