package com.example.books_storage.Controller;

import com.example.books_storage.Entity.AdvancedBook;
import com.example.books_storage.Entity.Book;
import com.example.books_storage.Service.BookPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class BookPageController {

    @Autowired
    private BookPageService bookPageService;


    @GetMapping("/book/{bookId}")
    public String bookPage(@PathVariable(value = "bookId") String bookId, Model model) {
        AdvancedBook bookInfo = bookPageService.getAdvancedInfoByID(bookId);
        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("similarBooks", bookPageService.similarBooks(bookInfo.getBook().getTitle()));
        return "book";
    }

    @PostMapping("/book/search")
    public String getSearchBook(@RequestParam(value = "bookName") String bookName) {
        return "redirect:/search/" + bookName;
    }

}
