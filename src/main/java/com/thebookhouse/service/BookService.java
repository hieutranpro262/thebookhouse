package com.thebookhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thebookhouse.model.Book;
import com.thebookhouse.repository.BookRepository;

public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.getOne(id);
    }

}
