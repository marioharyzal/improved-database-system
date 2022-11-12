package com.enigmacamp.student.validation;

import com.enigmacamp.student.model.Mahasiswa;

public abstract class ValidationMahasiswa {

    public static Validation minPanjangNama(int minPanjangNama) {
        return (Mahasiswa mahasiswa) ->
                mahasiswa.getNama().length() >= minPanjangNama;
    }

    public static Validation minPanjangJurusan(int minPanjangJurusan) {
        return (Mahasiswa mahasiswa) -> mahasiswa.getJurusan().getNamaJurusan().length() >= minPanjangJurusan;
    }
}
