package com.cepardov.spockexample.controller;

import com.cepardov.spockexample.dto.UserDto;
import com.cepardov.spockexample.exception.ExampleException;
import com.cepardov.spockexample.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ExampleController {

    @Autowired
    ExampleService service;

    @GetMapping
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("work", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) throws ExampleException {
        return new ResponseEntity<>(service.save(userDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) throws ExampleException {
        return new ResponseEntity<>(service.save(userDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> delete(@RequestBody UserDto userDto) throws ExampleException {
        Map<String, Object> response = new HashMap<>();
        service.delete(userDto);
        response.put("message", "Usuario eliminado");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
