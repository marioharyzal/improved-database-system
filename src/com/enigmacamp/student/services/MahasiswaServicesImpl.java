package com.enigmacamp.student.services;

import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.utils.ResponseStatus;

import java.util.List;

public interface MahasiswaServicesImpl {
    ResponseStatus<Mahasiswa> registerMahasiswa(Mahasiswa mahasiswa);

    ResponseStatus<List<Mahasiswa>> getAllMahasiswa();

    ResponseStatus<Mahasiswa> getMahasiswaByIndex(int index);

    ResponseStatus<String> unregisterMahasiswa();
}
