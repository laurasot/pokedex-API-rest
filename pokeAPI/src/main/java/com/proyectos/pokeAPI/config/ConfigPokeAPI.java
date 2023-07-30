package com.proyectos.pokeAPI.config;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigPokeAPI {

    @Bean() //el nombre es opcional
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) { // le esta metiendo el de arriba ja
        return webClientBuilder.baseUrl("https://pokeapi.co/api/v2").build();
    }
}
