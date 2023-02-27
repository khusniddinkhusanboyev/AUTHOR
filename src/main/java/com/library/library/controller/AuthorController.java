package com.library.library.controller;

import com.library.library.entity.Author;
import com.library.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping("/author")
    public String getAll(Model model){
        model.addAttribute("authors" , authorService.getAll());
        model.addAttribute("news" , new Author());
        return "author";
    }
    @PostMapping("/")
    public String add(@ModelAttribute Author author){
        authorService.add(author);
        return "redirect:/author";
    }

    @GetMapping("author/{id}")
    public String delete(@PathVariable("id") Long id){
                authorService.delete(id);
        return "redirect:/author";
    }

    @GetMapping("/updateAuthor/{id}")
    public String showPage(@PathVariable("id") Long id , Model model){
        model.addAttribute("author" , authorService.finByID(id).get());
        return "update/updateAuthor";
    }

    @PutMapping("/updateAuthor")
    public String updateAuthor(@ModelAttribute Author author){
        authorService.updateAuthor(author);
        return "redirect:/author";
    }
}
