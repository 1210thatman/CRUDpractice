package org.example.crudpractice.global.error.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CrudpracticeException {
    private final ErrorCode errorCode;
}
