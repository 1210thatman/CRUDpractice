package org.example.crudpractice.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //RuntimeException을 상속받아, ErrorCode를 가지면서 모든 Error들의 기본 틀을 제공?
public class CrudpracticeException extends RuntimeException {
    private final ErrorCode errorCode;
}