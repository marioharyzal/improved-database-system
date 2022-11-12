package com.enigmacamp.student.utils;

public class FailedResponse extends ResponseStatus{
    public FailedResponse(String error) {
        super(false, error, null);
    }
}
