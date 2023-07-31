package com.proyectos.pokeAPI.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectos.pokeAPI.entities.Pokemon;
import com.proyectos.pokeAPI.services.PokeAPIService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    //@Qualifier()
    private final PokeAPIService<Pokemon> pokeAPIService;
    public PokemonController(PokeAPIService<Pokemon> pokeAPIService){
        this.pokeAPIService = pokeAPIService;
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Pokemon> findByNamePokemon(@PathVariable String name){
        return new ResponseEntity<>(pokeAPIService.findByName(name), HttpStatus.OK) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findByIdPokemon(@PathVariable Integer id){
        return new ResponseEntity<>(pokeAPIService.findById(id), HttpStatus.OK);
    }


   /* @GetMapping("/name/ditto/move")
    public ResponseEntity<> findByNamePokemon1(){
        return new ResponseEntity<>(pokeAPIService.findByName("hola"), HttpStatus.OK) ;
    }*/
}
