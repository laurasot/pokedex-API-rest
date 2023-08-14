package com.proyectos.pokeAPI.controllers;

import com.proyectos.pokeAPI.entities.Pokemon;
import com.proyectos.pokeAPI.services.PokeAPIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokeAPIService<Pokemon> pokeAPIService;

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);
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


}
