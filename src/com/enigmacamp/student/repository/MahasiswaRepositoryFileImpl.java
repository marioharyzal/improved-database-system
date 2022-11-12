package com.enigmacamp.student.repository;
import com.enigmacamp.student.model.Jurusan;
import com.enigmacamp.student.model.Mahasiswa;
import com.enigmacamp.student.utils.exception.CapacityException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MahasiswaRepositoryFileImpl implements MahasiswaRepository {
    private final Path path;
    private int maxData;


    public MahasiswaRepositoryFileImpl(String path, int maxData) {
        try {
            this.path = Paths.get(path);
            boolean newFileExist = Files.exists(this.path);
            if (!newFileExist) Files.createFile(this.path);
            this.maxData = maxData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Stream<String> readData() {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeData(String content) {
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertData(String content) {
        try {
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Mahasiswa add(Mahasiswa mahasiswa) {
        long totalLines = readData().count();
        if (!(totalLines < maxData)) throw new CapacityException();
        insertData(mahasiswa.toCsv());
        return mahasiswa;
    }

    @Override
    public List<Mahasiswa> findAll() {
        return readData().map(s -> {
            String[] mahasiswaString = s.split(",");
            return new Mahasiswa(Integer.valueOf(mahasiswaString[0]), mahasiswaString[1], new Jurusan(mahasiswaString[2]));
        }).collect(Collectors.toList());
    }

    @Override
    public void delete() {
        List result = readData().sorted(Comparator.reverseOrder()).skip(1).collect(Collectors.toList());
        writeData(String.join("\n", result));
    }

    @Override
    public Mahasiswa findByIndex(int index) {
        return new Mahasiswa(readData().collect(Collectors.toList()).get(index));
    }
}
