package com.enigmacamp.student.utils.exception;

import com.enigmacamp.student.utils.StatusMessage;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super(StatusMessage.DATA_IS_EMPTY.toString());
    }
}
