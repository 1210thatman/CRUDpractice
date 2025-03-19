package org.example.crudpractice.global.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String status;

    public static ErrorResponse of(String message, String status){
        return ErrorResponse.builder()
                .message(message)
                .status(status)
                .build();
    }
}