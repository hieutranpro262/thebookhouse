package com.thebookhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebookhouse.dao.BookDAO;
import com.thebookhouse.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/getAlls")
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }
}
