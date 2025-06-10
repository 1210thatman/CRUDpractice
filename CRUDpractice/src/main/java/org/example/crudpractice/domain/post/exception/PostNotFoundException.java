package org.example.crudpractice.domain.post.exception;

import org.example.crudpractice.global.error.exceptions.CrudpracticeException;
import org.example.crudpractice.global.error.exceptions.ErrorCode;

public class PostNotFoundException extends CrudpracticeException {
    public static final CrudpracticeException EXCEPTION = new PostNotFoundException();

    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_EXIST);
    }
}
