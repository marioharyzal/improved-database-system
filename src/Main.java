import com.enigmacamp.student.model.Jurusan;
import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.repository.MahasiswaRepository;
import com.enigmacamp.student.repository.MahasiswaRepositoryFileImpl;
import com.enigmacamp.student.services.MahasiswaServices;
import com.enigmacamp.student.utils.ResponseStatus;
import com.enigmacamp.student.validation.ValidationMahasiswa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MahasiswaRepositoryImpl mahasiswaRepository = new MahasiswaRepositoryImpl(5);

        MahasiswaRepository mahasiswaRepository = new MahasiswaRepositoryFileImpl("/home/user/Dev/java/improved-basis-data/data.csv", 5);

        MahasiswaServices mahasiswaServices = new MahasiswaServices(mahasiswaRepository, ValidationMahasiswa.minPanjangNama(3), ValidationMahasiswa.minPanjangJurusan(3));

        Mahasiswa mahasiswa1 = new Mahasiswa(1, "Mario Haryzal", new Jurusan("TI"));
        Mahasiswa mahasiswa2 = new Mahasiswa(2, "Alucard", new Jurusan("TI"));
        Mahasiswa mahasiswa3 = new Mahasiswa(3, "Aweqqwql", new Jurusan("TI"));

        mahasiswaServices.registerMahasiswa(mahasiswa1);

        ResponseStatus<List<Mahasiswa>> daftarMahasiswa = mahasiswaServices.getAllMahasiswa();
        if (!daftarMahasiswa.isSuccess()) {
            System.err.println(daftarMahasiswa.getMessage());
        } else {
            for (Mahasiswa m : mahasiswaRepository.findAll()) {
                System.out.println(m);
            }
        }

        ResponseStatus<Mahasiswa> mahasiswa = mahasiswaServices.getMahasiswaByIndex(1);
        if (!mahasiswa.isSuccess()) {
            System.err.println(mahasiswa.getMessage());
        } else {
            System.out.println(mahasiswa.getData());
        }

        ResponseStatus<String> hapusMahasiswa = mahasiswaServices.unregisterMahasiswa();
        if (!hapusMahasiswa.isSuccess()) {
            System.err.println(hapusMahasiswa.getMessage());
        } else {
            System.out.println(hapusMahasiswa.getData());
        }
    }
}