package org.example.crudpractice.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR", "internal server error"),
    BOARD_NOT_FOUND(404, "BOARD_NOT_ERROR", "Board server error"),
    ADMIN_NAME_NOT_FOUND(404, "ADMIN_NAME_NOT_FOUND", "admin name not found");

    private final int status;
    private final String code;
    private final String message;
}
