package com.example.BookMVC_gptQ.service;

import com.example.BookMVC_gptQ.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImp implements BookService{
    private List<Book> books;

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> BookList() {
        return books;
    }
}
