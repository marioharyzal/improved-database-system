package com.enigmacamp.student.repository;

import com.enigmacamp.student.model.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
    Mahasiswa add(Mahasiswa mahasiswa);

    List<Mahasiswa> findAll();

    void delete();

    Mahasiswa findByIndex(int index);
}
