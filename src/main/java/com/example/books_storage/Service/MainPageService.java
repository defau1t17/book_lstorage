package com.example.books_storage.Service;

import com.example.books_storage.DTO.BookDTO;
import com.example.books_storage.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class MainPageService {

    private static final RestTemplate restTemplate = new RestTemplate();

    private ArrayList<Book> arrayOfBooks = new ArrayList<Book>();

    private static final String ALL_BOOKS_URL_REQUEST = "https://www.dbooks.org/api/recent";

    public ArrayList<Book> getAllBooks() {
        BookDTO forObject = restTemplate.getForObject(ALL_BOOKS_URL_REQUEST, BookDTO.class);
        arrayOfBooks.addAll(forObject.getBooks());
        return arrayOfBooks;
    }


}
