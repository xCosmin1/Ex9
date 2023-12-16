package com.example.ex9;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final FileDataRepository fileDataRepository;
    @Override
    public void run(String... args) throws Exception {
        FileData file1= FileData.builder()
                .fileName("filme")
                .extension("txt")
                .sizeInKb(10)
                .content("ana are mere")
                .build();
        FileData file2= FileData.builder()
                .fileName("masini")
                .extension("txt")
                .sizeInKb(10)
                .content("ana are mere")
                .build();
        FileData file3= FileData.builder()
                .fileName("povesti")
                .extension("txt")
                .sizeInKb(10)
                .content("ana are mere")
                .build();
        fileDataRepository.save(file1);
        fileDataRepository.save(file2);
        fileDataRepository.save(file3);
    }
}
