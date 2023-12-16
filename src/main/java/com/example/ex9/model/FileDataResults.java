package com.example.ex9.model;

import com.example.ex9.FileData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FileDataResults {
    List<FileData> results;
}
