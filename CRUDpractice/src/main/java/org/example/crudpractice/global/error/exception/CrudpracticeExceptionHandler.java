package org.example.crudpractice.global.error.exception;

import org.example.crudpractice.global.error.entity.ErrorResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrudpracticeExceptionHandler {
    @ExceptionHandler(CrudpracticeException.class)
    protected ResponseEntity<ErrorResponseEntity> handleCrudpracticeException(CrudpracticeException crudpracticeException) {
        //protected는 같은 패키지 내에서 사용이 가능, 다른 패키지라면 상속받은 경우 사용 가능
        return ErrorResponseEntity.responseEntity(crudpracticeException.getErrorCode());
    }
}
