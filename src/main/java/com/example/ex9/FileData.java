package com.example.ex9;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileData {
    @Id
    @GeneratedValue
    private UUID id;
    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;
}
