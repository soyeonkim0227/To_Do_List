package com.soyeonkim.todolist.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    NOT_FOUND_TODO(404, "C001", "Not Found Todo"),
    METHOD_NOT_ALLOWED(405, "C002", "Method Not Allowed"),
    INVALID_INPUT_VALUE(400, "C003", "Invalid Input Value"),
    INTERNAL_SERVER_ERROR(500, "C004", "Internal Server Error");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
