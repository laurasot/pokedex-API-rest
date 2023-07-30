package com.proyectos.pokeAPI.services;

import com.proyectos.pokeAPI.entities.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Primary
@Service
public class PokemonService implements PokeAPIService<Pokemon>{
    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(PokemonService.class);

    public PokemonService(WebClient webClient){
        this.webClient = webClient;
    }
    @Override
    public List<Pokemon> findAll() {
        return null;
    }

    @Override
    public Pokemon findById(Integer id) {
        try {
            Mono<Pokemon> response = webClient.get()
                    .uri("/pokemon/{id}", id).retrieve()
                    .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, clientResponse -> response.bodyToMono(Pokemon.class).map(CustomServerErrorException::new))
                    .onStatus(HttpStatus.BAD_REQUEST::equals, response -> response.bodyToMono(Pokemon.class).map( new WebClientResponseException));

        }

        return null;
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
