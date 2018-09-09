package com.thebookhouse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebookhouse.exception.EntityException;
import com.thebookhouse.model.Book;
import com.thebookhouse.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/findAll")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/findOne/{bookId}")
    public Book findOne(@PathVariable int bookId) {
        Book book = bookService.findOne(bookId);
        if (book == null) {
            throw new EntityException("Book not found. Please check everything again.", HttpStatus.NOT_FOUND);
        }
        return book;
    }

    @PostMapping
    public Book add(@Valid @RequestBody Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityException("Please fill the information correctly.", HttpStatus.BAD_REQUEST);
        }
        return bookService.add(book);
    }

    @PutMapping
    public Book update(@Valid @RequestBody Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityException("Please fill the information correctly.", HttpStatus.BAD_REQUEST);
        }
        return bookService.update(book);
    }

    @DeleteMapping("/{bookId}")
    public Book delete(@PathVariable int bookId) {
        Book deletedBook = bookService.findOne(bookId);
        if (deletedBook == null) {
            throw new EntityException("Book not found. Please check everything again.", HttpStatus.NOT_FOUND);
        }
        return bookService.delete(deletedBook);
    }

}
