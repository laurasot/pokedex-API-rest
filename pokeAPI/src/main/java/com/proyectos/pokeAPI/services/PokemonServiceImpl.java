package com.proyectos.pokeAPI.services;

import com.proyectos.pokeAPI.entities.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Primary
@Service
public class PokemonServiceImpl implements PokeAPIService<Pokemon>{
    private final WebClient webClient;

    private static final Logger logger = LoggerFactory.getLogger(PokemonServiceImpl.class);

    public PokemonServiceImpl(WebClient webClient){
        this.webClient = webClient;
    }
    @Override
    public List<Pokemon> findAll() {
        return null;
    }

    @Override
    public Pokemon findById(Integer id) {
        try {
            return webClient.get().uri("/pokemon/{id}", id).retrieve().bodyToMono(Pokemon.class).block();
        }catch (HttpClientErrorException.BadRequest exception){
            logger.error("bad requesito");
            return null;
        }

    }

    @Override
    public Pokemon findByName(String name) {
        return webClient.get().uri("/pokemon/{name}", name).retrieve().bodyToMono(Pokemon.class).block();
        /*try {
            return webClient.get().uri("/pokemon/{name}", name).retrieve().bodyToMono(Pokemon.class).block();
        } catch (WebClientResponseException ex){ //respuesta no exitosa
            logger.error("Error HTTP: {} {}", ex.getStatusCode(), ex.getStatusText());
            return null;
        } catch (Exception e){
            logger.error("Error: {}", e.getMessage());
            return null;
        }*/



    }


}
