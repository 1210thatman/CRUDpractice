package org.example.crudpractice.domain.board.exception;

import org.example.crudpractice.global.error.exception.CrudpracticeException;
import org.example.crudpractice.global.error.exception.ErrorCode;

public class BoardNotFoundException extends CrudpracticeException {
public static final CrudpracticeException EXCEPTION = new BoardNotFoundException();

public BoardNotFoundException() {super(ErrorCode.BOARD_NOT_FOUND);}
}
