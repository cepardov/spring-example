package com.cepardov.spockexample.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private Long id;
    private String name;
    private Date created;
    private Date updated;

}
