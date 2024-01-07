package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public StudentWrapper(String message, Object data) {
        this.message = message;
        this.data = data;
        this.success=true;
        this.code= HttpStatus.OK.value();
    }

    public StudentWrapper(String message) {
        this.message = message;
        this.success=true;
        this.code=HttpStatus.OK.value();
    }
}
