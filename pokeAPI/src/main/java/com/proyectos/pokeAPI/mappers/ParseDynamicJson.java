package com.proyectos.pokeAPI.mappers;



import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ParseDynamicJson {/*
    public static void getKey(JSONObject json, String key){
        boolean exists = json.has(key);
        if (!exists){
        }else {
            parseObjec(json,key);
        }

    }

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // Leer la respuesta JSON desde la conexión
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            String jsonRespuesta = response.toString();

        }

    }*/
}
