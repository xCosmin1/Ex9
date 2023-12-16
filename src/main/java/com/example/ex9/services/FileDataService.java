package com.example.ex9.services;

import com.example.ex9.FileDataRepository;
import com.example.ex9.model.FileDataResults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataResults getAllFiles() {
       return FileDataResults.builder()
                .results(fileDataRepository.findAll())
                .build();
    }
}
