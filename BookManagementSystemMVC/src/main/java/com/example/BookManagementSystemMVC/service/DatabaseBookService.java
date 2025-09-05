package com.example.BookManagementSystemMVC.service;

import com.example.BookManagementSystemMVC.domain.Book;
import com.example.BookManagementSystemMVC.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseBookService implements BookService{
    private final BookRepository bookRepository;

    public DatabaseBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
