package com.cepardov.spockexample.service;

import com.cepardov.spockexample.dto.UserDto;
import com.cepardov.spockexample.entity.User;
import com.cepardov.spockexample.exception.ExampleException;
import com.cepardov.spockexample.repository.ExampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto save(UserDto userDto) throws ExampleException {
        if (userDto.getName().isEmpty()) throw new ExampleException(1, "Nombre no puede estar vacío");
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(repository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = repository.findAll();
        return userList.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) throws ExampleException {
        if (id == null) throw new ExampleException(2, "Id está vacío");
        return modelMapper.map(repository.findById(id), UserDto.class);
    }

    @Override
    public void delete(UserDto userDto) throws ExampleException {
        if (userDto == null || userDto.getId() == null) throw new ExampleException(3, "Usuario no se puede eliminar, error en datos");
        repository.delete(modelMapper.map(userDto, User.class));
    }
}
