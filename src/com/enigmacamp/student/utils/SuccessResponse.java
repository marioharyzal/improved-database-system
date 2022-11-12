package com.enigmacamp.student.utils;

public class SuccessResponse<T> extends ResponseStatus {

    public SuccessResponse(T data) {
        super(true, null, data);
    }
}
