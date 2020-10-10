package com.cepardov.spockexample.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExampleException extends Exception {

    final Integer code;
    final String message;
}
