package com.example.BookMVC_gptQ.service;

import com.example.BookMVC_gptQ.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> BookList();
}
