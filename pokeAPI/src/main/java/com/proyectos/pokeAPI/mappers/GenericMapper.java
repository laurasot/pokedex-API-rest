package com.proyectos.pokeAPI.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class GenericMapper {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(GenericMapper.class);

    public  <T> String serialize(T object){
        String data = null;
        try {
            data = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e){
            logger.error("Error en el proceso de serializacion. Detalles {}", e.getMessage());
        }
        return data;
    }

    public  <T> T deserialize(String json, Class<T> type){
        T data = null;
        try{
            data = mapper.readValue(json, type);
        }catch (IOException e){
            logger.error("Error en el proceso de deserializacion. Detalles {}", e.getMessage());
        }
        return data;
    }

    public <T> T deserializeList (String json, Class<T> type){
        T data = null;
        //List<T> list = mapper.readValue(json, type);
        try{
            data = mapper.readValue(json,type);
            System.out.println(data);
        }catch (IOException e){
            logger.error("Error en el proceso de deserializacion de la lista de objetos. Detalles {}", e.getMessage());
        }
        return data;
    }

}
