package com.proyectos.pokeAPI.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict( RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<Object> WRespClientException( WebClientResponseException ex, WebRequest req){
        String bodyOfResponse = String.format("Error HTTP,  status: %s, message: %s parameters: %s", ex.getStatusCode(), ex.getStatusText(), req.getParameterNames());
        logger.error(bodyOfResponse);
        return new ResponseEntity<>(bodyOfResponse,new HttpHeaders(), ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exceptionHandler( Exception e, WebRequest req){
        String bodyOfResponse = String.format("Error,  message: %s, Cause: %s parameters: %s", e.getMessage(), e.getCause(), req.getParameterNames());
        logger.error(bodyOfResponse);
        return handleExceptionInternal (e, bodyOfResponse,new HttpHeaders(), HttpStatus.CONFLICT, req);
    }
    @ExceptionHandler(WebClientRequestException.class)
    public ResponseEntity<Object> WReqClientException( WebClientResponseException ex, WebRequest req){
        String bodyOfResponse = String.format("Error en el request,  status:%s, message:%s, parameters:%s", ex.getStatusCode(), ex.getStatusText(), req.getParameterNames());
        logger.error(bodyOfResponse);
        return new ResponseEntity<>(bodyOfResponse,new HttpHeaders(), ex.getStatusCode());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> BadReqClientException( WebClientResponseException ex, WebRequest req){
        String bodyOfResponse = String.format("Error en el request,  status:%s, message:%s, parameters:%s", ex.getStatusCode(), ex.getStatusText(), req.getParameterNames());
        logger.error(bodyOfResponse);
        return new ResponseEntity<>(bodyOfResponse,new HttpHeaders(), ex.getStatusCode());
    }

}
