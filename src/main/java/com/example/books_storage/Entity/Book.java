package com.example.books_storage.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private String id;
    private String title;
    private String authors;
    private String image;

}
