package com.activemq.utils;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GeneralResponse {
    public String message;
    public HttpStatus status;

}
