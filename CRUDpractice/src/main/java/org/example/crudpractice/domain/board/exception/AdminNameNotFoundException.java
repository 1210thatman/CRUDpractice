package org.example.crudpractice.domain.board.exception;

import org.example.crudpractice.global.error.exception.CrudpracticeException;
import org.example.crudpractice.global.error.exception.ErrorCode;

public class AdminNameNotFoundException extends CrudpracticeException {
    public static final CrudpracticeException EXCEPTION = new AdminNameNotFoundException();
    public AdminNameNotFoundException() {super(ErrorCode.ADMIN_NAME_NOT_FOUND);}
}
