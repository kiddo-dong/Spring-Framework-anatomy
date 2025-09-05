package com.example.BookManagementSystemMVC.service;

import com.example.BookManagementSystemMVC.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryBookService implements BookService{
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
