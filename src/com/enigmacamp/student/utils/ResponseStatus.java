package com.enigmacamp.student.utils;

public abstract class ResponseStatus<T> {
    private final boolean isSuccess;

    private final String message;

    private T data;

    public ResponseStatus(boolean isSuccess, String message, T data) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message.toString();
    }

    public T getData() {
        return data;
    }
}
