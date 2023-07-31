package com.proyectos.pokeAPI.services;

import com.proyectos.pokeAPI.entities.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
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
            return webClient.get()
                    .uri("/pokemon/{id}", id).retrieve().onStatus(HttpStatus.NOT_FOUND::equals,
                            response -> response.bodyToMono(Pokemon.class).map(pokemon -> new Exception("Not Found"))).bodyToMono(Pokemon.class).block();
        }catch (Exception e){
            logger.error("Error: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Pokemon findByName(String name) {
        try {
            return webClient.get().uri("/pokemon/{name}", name).retrieve().bodyToMono(Pokemon.class).block();
        } catch (WebClientResponseException ex){ //respuesta no exitosa
            logger.error("Error HTTP: {} {}", ex.getStatusCode(), ex.getStatusText());
            return null;
        } catch (Exception e){
            logger.error("Error: {}", e.getMessage());
            return null;
        }

    }
}
