package com.example.books_storage.Service;

import com.example.books_storage.DTO.AdvancedBookDTO;
import com.example.books_storage.Entity.AdvancedBook;
import com.example.books_storage.Entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;

@Service
public class BookPageService {

    private static final RestTemplate restTemplate = new RestTemplate();

    private static final String DETAILED_B0OOK_INFO_REQUEST = "https://www.dbooks.org/api/book/";


    public AdvancedBook getAdvancedInfoByID(String id) {
        AdvancedBookDTO object = restTemplate.getForObject(DETAILED_B0OOK_INFO_REQUEST + "" + id.toLowerCase(), AdvancedBookDTO.class);
        AdvancedBook advancedBook = new AdvancedBook();
        Book book = new Book();
        book.setId(id);
        book.setTitle(object.getTitle());
        book.setAuthors(object.getAuthors());
        book.setImage(object.getImage());
        advancedBook.setBook(book);
        advancedBook.setDescription(object.getDescription());
        advancedBook.setPages(object.getPages());
        advancedBook.setYear(object.getYear());
        System.out.println(object);
        return advancedBook;
    }


}
