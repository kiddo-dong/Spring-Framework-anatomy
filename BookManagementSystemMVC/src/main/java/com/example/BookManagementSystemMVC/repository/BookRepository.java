package com.example.BookManagementSystemMVC.repository;

import com.example.BookManagementSystemMVC.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> findAll();
    void save(Book book);
}
