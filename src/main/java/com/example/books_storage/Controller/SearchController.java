package com.example.books_storage.Controller;

import com.example.books_storage.Entity.Book;
import com.example.books_storage.Service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class SearchController {

    @Autowired
    private SearchService service;


    @GetMapping("/search")
    public String defaultSearch() {

        return "search";
    }

    @GetMapping("/search/{book}")
    public String search(@PathVariable(value = "book") String bookName, Model model) {
        System.out.println(bookName);
        model.addAttribute("searchedBooks", service.findBooks(bookName).getBooks());
        model.addAttribute("bookN", bookName);
        return "search";
    }

    @PostMapping("/search/{book}")
    public String search(@PathVariable(value = "book") String book, @RequestParam(value = "bookName") String bookName, Model model) {
        model.addAttribute("searchedBooks", service.findBooks(bookName).getBooks());
        model.addAttribute("bookN", bookName);
        return "redirect:/search/" + bookName;
    }


}
