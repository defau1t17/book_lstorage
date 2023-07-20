package com.example.books_storage.Controller;

import com.example.books_storage.Entity.AdvancedBook;
import com.example.books_storage.Service.BookPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookPageController {

    @Autowired
    private BookPageService bookPageService;


    @GetMapping("/book/{bookId}")
    public String bookPage(@PathVariable(value = "bookId") String bookId, Model model) {
        System.out.println(bookId);
        AdvancedBook bookInfo = bookPageService.getAdvancedInfoByID(bookId);
        model.addAttribute("bookInfo",bookInfo);

        return "book";
    }




}
