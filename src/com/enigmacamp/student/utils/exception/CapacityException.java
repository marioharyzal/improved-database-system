package com.enigmacamp.student.utils.exception;

import com.enigmacamp.student.utils.StatusMessage;

public class CapacityException extends RuntimeException {
    public CapacityException() {
        super(StatusMessage.NOT_ENOUGHT_SPACES.toString());
    }
}
