package com.thebookhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebookhouse.model.Book;
import com.thebookhouse.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/findOne/{bookId}")
    public Book findOneBook(@PathVariable int bookID) {
        return bookService.findOne(bookID);
    }
}
