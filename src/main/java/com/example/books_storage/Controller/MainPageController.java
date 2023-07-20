package com.example.books_storage.Controller;


import com.example.books_storage.Entity.Book;
import com.example.books_storage.Service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class MainPageController {


    @Autowired
    private MainPageService mainPageService;

    @GetMapping("/")
    public String mainPage(Model model) {
        ArrayList<Book> allBooks = mainPageService.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "main";
    }

    @PostMapping("/")
    public String mainPage(@RequestParam(value = "bookId") String bookId) {
        System.out.println(bookId + " ///");
        return "redirect:/book/" + bookId.toLowerCase();
    }


}
