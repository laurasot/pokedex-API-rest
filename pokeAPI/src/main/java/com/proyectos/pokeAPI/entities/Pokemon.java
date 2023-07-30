package com.proyectos.pokeAPI.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Pokemon {
    private Integer id;

    private String name;

    private int height;
    private int weigh;

    private List<MoveGroup> moves;

    private List<Abilities> abilities;


}
