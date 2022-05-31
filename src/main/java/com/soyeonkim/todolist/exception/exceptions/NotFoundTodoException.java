package com.soyeonkim.todolist.exception.exceptions;

import com.soyeonkim.todolist.exception.BusinessException;
import com.soyeonkim.todolist.exception.ErrorCode;

public class NotFoundTodoException extends BusinessException {

    public NotFoundTodoException() {
        super(ErrorCode.NOT_FOUND_TODO.getMessage());
        setErrorCode(ErrorCode.NOT_FOUND_TODO);
    }
}
