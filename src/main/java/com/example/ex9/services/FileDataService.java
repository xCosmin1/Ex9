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

    public UUID createFile(FileData fileData) {
        fileDataRepository.save(fileData);
        return fileData.getId();
    }

    public void updateFile(FileData fileData, UUID id) {
        //TODO try to find file first. If found set the new values and save it
       FileData existingInDB=getFileById(id);
        existingInDB.setFileName(fileData.getFileName());
        existingInDB.setExtension(fileData.getExtension());
        existingInDB.setContent(fileData.getContent());
        existingInDB.setSizeInKb(fileData.getSizeInKb());
        fileDataRepository.save(existingInDB);
    }

    public void deleteFileById(UUID id) {
        getFileById(id);
        fileDataRepository.deleteById(id);
    }
}
