package com.cepardov.spockexample.service;

import com.cepardov.spockexample.dto.UserDto;
import com.cepardov.spockexample.exception.ExampleException;

import java.util.List;

public interface ExampleService {

    UserDto save(UserDto userDto) throws ExampleException;
    List<UserDto> findAll();
    UserDto findById(Long id) throws ExampleException;
    void delete(UserDto userDto) throws ExampleException;
}
