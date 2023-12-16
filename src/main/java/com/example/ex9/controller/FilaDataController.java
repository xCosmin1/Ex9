package com.example.ex9.controller;

import com.example.ex9.FileData;
import com.example.ex9.exceptions.SdaException;
import com.example.ex9.model.FileDataResults;
import com.example.ex9.services.FileDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/files-data")
public class FilaDataController {

    private final FileDataService fileDataService;



    @GetMapping
    public FileDataResults showAllData(){
        return fileDataService.getAllFiles();
    }

    @GetMapping("{id}")
    public FileData getFileById(@PathVariable UUID id){
        return fileDataService.getFileById(id);
    }

    @PostMapping()
    public ResponseEntity<FileData> getFileById(@RequestBody FileData fileData) throws URISyntaxException {
        //TODO create entity in service and return id for that entity
        UUID entityId= fileDataService.createFile(fileData);

        return ResponseEntity.created(new URI("/api/files-data"+entityId)).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateFile(@RequestBody FileData fileData, @PathVariable UUID id){
        //TODO use servi
        fileDataService.updateFile(fileData,id);
    }

    @ExceptionHandler(SdaException.class)
    public String handleErrors(SdaException ex){
        log.error("Error processing request",ex);
        return ex.getMessage();
    }

}
