package com.proyectos.pokeAPI.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MoveGroup {
    private Move move;

    //@JsonProperty("version_group_details")
    //private List<VersionGroupDetails> versionGroupDetails;
}
