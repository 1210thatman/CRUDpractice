package org.example.crudpractice.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BOARD_NOT_FOUND(404, "BOARD_NOT_ERROR", "Board server error"),
    ADMIN_NAME_NOT_FOUND(404, "ADMIN_NAME_NOT_FOUND", "admin name not found");

    private final int status;
    private final String code;
    private final String message;
}
