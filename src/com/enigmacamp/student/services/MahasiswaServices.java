package com.enigmacamp.student.services;
import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.repository.MahasiswaRepository;
import com.enigmacamp.student.utils.StatusMessage;
import com.enigmacamp.student.utils.FailedResponse;
import com.enigmacamp.student.utils.ResponseStatus;
import com.enigmacamp.student.utils.SuccessResponse;
import com.enigmacamp.student.validation.Validation;
import java.util.List;

public class MahasiswaServices implements MahasiswaServicesImpl {

    private MahasiswaRepository mahasiswaRepository;
    private Validation panjangNama;
    private Validation panjangJurusan;

    public MahasiswaServices(MahasiswaRepository mahasiswaRepository, Validation panjangNama, Validation panjangJurusan) {
        this.mahasiswaRepository = mahasiswaRepository;
        this.panjangNama = panjangNama;
        this.panjangJurusan = panjangJurusan;
    }

    @Override
    public ResponseStatus<Mahasiswa> registerMahasiswa(Mahasiswa mahasiswa) {
        if (!this.panjangNama.validate(mahasiswa))
            return new FailedResponse(StatusMessage.INVALID_LENGTH_NAME.toString());
        if (!this.panjangJurusan.validate(mahasiswa))
            return new FailedResponse(StatusMessage.INVALID_LENGTH_JURUSAN.toString());

        try {
            Mahasiswa mahasiswaTerdaftar = mahasiswaRepository.add(mahasiswa);
            return new SuccessResponse<>(mahasiswaTerdaftar);
        } catch (Exception e) {
            return new FailedResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<List<Mahasiswa>> getAllMahasiswa() {
        try {
            return new SuccessResponse<>(mahasiswaRepository.findAll());
        } catch (Exception e) {
            return new FailedResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<Mahasiswa> getMahasiswaByIndex(int index) {
        try {
            return new SuccessResponse<>(mahasiswaRepository.findByIndex(index));
        } catch (Exception e) {
            return new FailedResponse(e.getMessage());
        }
    }

    @Override
    public ResponseStatus<String> unregisterMahasiswa() {
        if (mahasiswaRepository.findAll().isEmpty()) return new FailedResponse(StatusMessage.DATA_IS_EMPTY.toString());

        try {
            mahasiswaRepository.delete();
            return new SuccessResponse(StatusMessage.SUCCESS.toString());
        } catch (Exception e) {
            return new FailedResponse(e.getMessage());
        }
    }
}
