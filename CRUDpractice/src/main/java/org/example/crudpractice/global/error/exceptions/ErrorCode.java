package org.example.crudpractice.global.error.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    BOARD_NOT_EXIST(404, "board not exist"),
    ADMIN_NAME_NOT_EXIST(404, "admin name not exist"),
    POST_NOT_EXIST(404, "post not found");

    private int statusCode;
    private String message;
}
