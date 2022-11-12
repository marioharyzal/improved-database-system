package com.enigmacamp.student.repository;
import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.utils.exception.CapacityException;
import com.enigmacamp.student.utils.exception.DataNotFoundException;
import com.enigmacamp.student.utils.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepositoryImpl implements MahasiswaRepository{

    private List<Mahasiswa> kumpulanMahassiswa = new ArrayList<>();

    private int maxData;

    public MahasiswaRepositoryImpl(int maxData) {
        this.maxData = maxData;
    }

    @Override
    public Mahasiswa add(Mahasiswa mahasiswa) {
        if (!(kumpulanMahassiswa.size() < maxData)){
            throw new CapacityException();
        }
        kumpulanMahassiswa.add(mahasiswa);
        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> findAll() {
        if (kumpulanMahassiswa.isEmpty()) {
            throw new EmptyListException();
        }
        return kumpulanMahassiswa;
    }

    @Override
    public void delete() {
        if (kumpulanMahassiswa.isEmpty()){
            throw new EmptyListException();
        }
        kumpulanMahassiswa.remove(kumpulanMahassiswa.size()-1);
    }

    @Override
    public Mahasiswa findByIndex(int index) {
        if (index >= 0 && index <= kumpulanMahassiswa.size()){
            return kumpulanMahassiswa.get(index);
        } else {
            throw new DataNotFoundException();
        }
    }
}
