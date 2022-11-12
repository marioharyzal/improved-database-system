package com.enigmacamp.student.utils.exception;

import com.enigmacamp.student.utils.StatusMessage;

public class EmptyListException extends RuntimeException {
    public EmptyListException() {
        super(StatusMessage.DATA_IS_EMPTY.toString());
    }
}
