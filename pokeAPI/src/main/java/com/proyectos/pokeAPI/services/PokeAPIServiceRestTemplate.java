package com.proyectos.pokeAPI.services;

import com.proyectos.pokeAPI.entities.Pokemon;
import com.proyectos.pokeAPI.mappers.GenericMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokeAPIServiceRestTemplate implements PokeAPIService<Pokemon>{
    private final GenericMapper genericMapper;
    private final RestTemplate restTemplate;

    public PokeAPIServiceRestTemplate(RestTemplate restTemplate, GenericMapper genericMapper){
        this.restTemplate = restTemplate;
        this.genericMapper = genericMapper;
    }
    @Override
    public List<Pokemon> findAll() {

        return null;
    }

    @Override
    public Pokemon findById(Integer id) {
        //JsonNode pokemon = restTemplate.getForObject("http://servicio-productos/listar/{id}",)
        return null;
    }
    @Override
    public Pokemon findByName(String name) {
        ResponseEntity<Pokemon> response = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/{name}",
                HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {},name);
        ResponseEntity<String> jsonResponse = restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/{name}", HttpMethod.GET, null, String.class, name);
        //String json = jsonResponse.getBody();

        //Pokemon pokemon = genericMapper.deserialize(json, Pokemon.class);
        //Move move = genericMapper.deserialize(json, Move.class);

        return response.getBody();
    }
}
