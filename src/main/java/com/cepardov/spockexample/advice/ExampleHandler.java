package com.cepardov.spockexample.advice;

import com.cepardov.spockexample.exception.ExampleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ExampleHandler {

    @ExceptionHandler(ExampleException.class)
    public ResponseEntity<Map<String, Object>> exampleException(ExampleException e) {
        log.error("Error: {}", e.getLocalizedMessage(), e);
        Map<String, Object> response = new HashMap<>();
        response.put("code", e.getCode());
        response.put("message", e.getMessage());
        response.put("errorMsg", e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> generalException(Exception e) {
        log.error("Error: {}", e.getLocalizedMessage(), e);
        Map<String, Object> response = new HashMap<>();
        response.put("code", 9999);
        response.put("message", "Error de servidor");
        response.put("errorMsg", e.getLocalizedMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
