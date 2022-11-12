package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.utils.ResponseStatus;

public interface Validation {
    Boolean validate(Mahasiswa mahasiswa);
}
