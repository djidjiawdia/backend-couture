package com.couture.backend.model;

import lombok.Data;

@Data
public class FieldError {

    private String field;
    private String errorCode;

}
