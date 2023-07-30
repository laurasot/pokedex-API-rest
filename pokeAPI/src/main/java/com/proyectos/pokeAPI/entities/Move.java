package com.proyectos.pokeAPI.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Move {
    private Integer id;
    @JsonProperty("name")
    public String name;
    private String url;
    //public  List<Pokemon> learned_by_pokemon;
}
