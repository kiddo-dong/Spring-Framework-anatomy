package com.example.BookManagementSystemMVC.controller;

import com.example.BookManagementSystemMVC.domain.Book;
import com.example.BookManagementSystemMVC.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookController {
    private final Map<String, BookService> stringBookServiceMap;

    public BookController(Map<String, BookService> stringBookServiceMap) {
        this.stringBookServiceMap = stringBookServiceMap;
    }

    @GetMapping("/books")
    public String findAllBooks(@RequestParam String type,
                               Model model){
      model.addAttribute("books",stringBookServiceMap.get(type).getBooks());
      return "books";
    };

    @PostMapping("/books")
    public String addBook(@RequestParam String type,
                          @ModelAttribute Book book,
                          Model model){
        stringBookServiceMap.get(type).addBook(book);
        return "redirect:/books?type="+type;
    }
}
