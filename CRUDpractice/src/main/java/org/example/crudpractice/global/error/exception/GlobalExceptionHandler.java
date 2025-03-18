package org.example.crudpractice.global.error.exception;
import org.example.crudpractice.global.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BoardException.class)
    public ResponseEntity<ErrorResponse> handleGlobal(BoardException exception) {
        final ErrorCode errorCode = exception.getErrorCode();
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus())
        );
    }
}
