package com.example.books_storage.Service;


import com.example.books_storage.DTO.BookDTO;
import com.example.books_storage.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class SearchService {

    private static final RestTemplate restTemplate = new RestTemplate();

    private ArrayList<Book> arrayOfBooks = new ArrayList<Book>();

    private static final String SEARCH_BOOK_BY_NAME = "https://www.dbooks.org/api/search/";

    public BookDTO findBooks(String bookName) {
        BookDTO books = restTemplate.getForObject(SEARCH_BOOK_BY_NAME + bookName, BookDTO.class);
        return books;
    }



}
