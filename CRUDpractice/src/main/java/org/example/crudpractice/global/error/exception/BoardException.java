package org.example.crudpractice.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardException extends RuntimeException {
    private final ErrorCode errorCode;
}
