package com.example.books_storage.DTO;

import lombok.Data;

@Data
public class AdvancedBookDTO {
    private String id;
    private String title;
    private String authors;
    private String image;
    private String description;
    private int pages;
    private int year;

}
