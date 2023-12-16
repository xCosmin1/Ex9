package com.example.ex9.services;

import com.example.ex9.FileData;
import com.example.ex9.FileDataRepository;
import com.example.ex9.exceptions.SdaException;
import com.example.ex9.model.FileDataResults;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataResults getAllFiles() {
       return FileDataResults.builder()
                .results(fileDataRepository.findAll())
                .build();
    }

    public FileData getFileById(UUID id) {
       return fileDataRepository.findById(id).orElseThrow(()->new SdaException("Could not find file with id " + id));
    }
}
