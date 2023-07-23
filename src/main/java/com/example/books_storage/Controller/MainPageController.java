package com.example.books_storage.Controller;


import com.example.books_storage.Entity.Book;
import com.example.books_storage.Service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class MainPageController {


    @Autowired
    private MainPageService mainPageService;

    @GetMapping("/books")
    public String mainPage(Model model) {
        model.addAttribute("allBooks",mainPageService.getAllBooks().getBooks());
        return "main";
    }

    @PostMapping("/books")
    public String mainPage(@RequestParam(value = "bookId") String bookId) {
        System.out.println(bookId);
        return "redirect:/book/" + bookId.toLowerCase();
    }

    @PostMapping("/books/search")
    public String getSearchParam(@RequestParam(value = "bookName") String bookName) {
        return "redirect:/search/" + bookName;
    }

}
