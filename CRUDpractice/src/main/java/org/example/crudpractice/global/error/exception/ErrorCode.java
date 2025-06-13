package org.example.crudpractice.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT) //이거모죠?
public enum ErrorCode {
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    BOARD_NOT_FOUND(404, "board not found"),
    ADMIN_NAME_NOT_FOUND(404, "admin name not found"),
    POST_NOT_FOUND(404, "post not found");

    private Integer httpStatus;
    private String message;
}
