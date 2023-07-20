package com.example.books_storage.Entity;

import lombok.Data;

@Data
public class AdvancedBook {
    private Book book;
    private String description;
    private int pages;
    private int year;
}
