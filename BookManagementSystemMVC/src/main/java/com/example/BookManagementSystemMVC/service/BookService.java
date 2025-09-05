package com.example.BookManagementSystemMVC.service;

import com.example.BookManagementSystemMVC.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    void addBook(Book book);
}
