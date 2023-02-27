package com.library.library.controller;

import com.library.library.entity.Publisher;
import com.library.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {
    @Autowired
    PublisherService publisherService;
    @GetMapping("/publisher")
    public String getAllPublisher(Model model){
        model.addAttribute("publishers" , publisherService.getAll());
        model.addAttribute("newPublisher" ,new Publisher());
        return "publisher";
    }

    @PostMapping("/addPublisher")
    public String addPublisher(@ModelAttribute Publisher publisher){
        publisherService.addPublisher(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable("id") Long id){
        publisherService.deletePublusher(id);
        return "redirect:/publisher";
    }
}
