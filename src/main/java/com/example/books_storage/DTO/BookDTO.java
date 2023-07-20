package com.example.books_storage.DTO;

import com.example.books_storage.Entity.Book;
import lombok.Data;

import java.util.ArrayList;

@Data
public class BookDTO {
    private ArrayList<Book> books;
}
