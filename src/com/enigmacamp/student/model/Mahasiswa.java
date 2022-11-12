package com.enigmacamp.student.model;

import java.util.Arrays;

public class Mahasiswa {
    protected Integer id;
    protected String nama;
    protected Jurusan jurusan;

    public Mahasiswa(Integer id, String nama, Jurusan jurusan) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa {" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", jurusan=" + jurusan +
                "}";
    }

    public Mahasiswa(String csv) {
        String[] mahasiswa = csv.split(",");
        this.id = Integer.parseInt(mahasiswa[0]);
        this.nama = mahasiswa[1];
        this.jurusan = new Jurusan(mahasiswa[2]);
    }

    public String toCsv() {
        return String.join(",", Arrays.asList(id.toString(), nama, jurusan.getNamaJurusan() + "\n"));
    }
}
