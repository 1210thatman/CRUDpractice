package org.example.crudpractice.global.error;

import lombok.Builder;

@Builder
public class ErrorResponse {
    private final int status;
    private final String code;
    private final String message;
}