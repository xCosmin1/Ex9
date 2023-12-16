package com.example.ex9.controller;

import com.example.ex9.FileData;
import com.example.ex9.exceptions.SdaException;
import com.example.ex9.model.FileDataResults;
import com.example.ex9.services.FileDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @ExceptionHandler(SdaException.class)
    public String handleErrors(SdaException ex){
        log.error("Error processing request",ex);
        return ex.getMessage();
    }

}
