package com.maveric.transactionservicetest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String code;
    private String message;
}