package com.example.BookMVC_gptQ.controller;

import com.example.BookMVC_gptQ.domain.Book;
import com.example.BookMVC_gptQ.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "/book/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return "redirect:/book/list";
    }

    @RequestMapping(path = "/book/list", method = RequestMethod.GET)
    public String viewBook(Model model){
        model.addAttribute("Booklist",bookService.BookList());
        return "book/list";
    }

}