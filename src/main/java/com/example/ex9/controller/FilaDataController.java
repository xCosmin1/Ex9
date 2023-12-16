package com.example.ex9.controller;

import com.example.ex9.FileData;
import com.example.ex9.FileDataRepository;
import com.example.ex9.model.FileDataResults;
import com.example.ex9.services.FileDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/files-data")
public class FilaDataController {

    private final FileDataService fileDataService;



    @GetMapping
    public FileDataResults showAllData(){
        return fileDataService.getAllFiles();
    }
}
