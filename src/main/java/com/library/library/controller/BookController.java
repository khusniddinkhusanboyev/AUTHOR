package com.library.library.controller;

import com.library.library.entity.Book;
import com.library.library.service.BookService;
import com.library.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    PublisherService publisherService;
    @Autowired
    BookService bookService;
    @GetMapping("/book")
    public String getAllBook(Model model){
        model.addAttribute("books" , bookService.getAll());
        model.addAttribute("newBook" , new Book());
        model.addAttribute("publishers" , publisherService.getAll());
        return "book";
    }
    @PostMapping("/newBook")
    public String addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/book";
    }
}
