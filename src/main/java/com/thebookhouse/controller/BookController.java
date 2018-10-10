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
            throw new EntityException(
                    "Book not found. Please check everything again.", HttpStatus.NOT_FOUND);
        }
        return book;
    }

    @GetMapping("/findByType/{bookTypeId}")
    public List<Book> findByType(@PathVariable int bookTypeId) {
        List<Book> books = bookService.findByType(bookTypeId);
        if (books.isEmpty()) {
            throw new EntityException(
                    "No book found for this type currently.", HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @GetMapping("/findByAuthor/{authorId}")
    public List<Book> findByAuthor(@PathVariable int authorId) {
        List<Book> books = bookService.findByAuthor(authorId);
        if (books.isEmpty()) {
            throw new EntityException(
                    "No book found for this author currently.", HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @GetMapping("/findByCompany/{companyId}")
    public List<Book> findByCompany(@PathVariable int companyId) {
        List<Book> books = bookService.findByCompany(companyId);
        if (books.isEmpty()) {
            throw new EntityException(
                    "No book found for this company currently.", HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @GetMapping("/findByPriceRange/{minPrice},{maxPrice}")
    public List<Book> findByPriceRange(@PathVariable float minPrice, @PathVariable float maxPrice) {
        List<Book> books = bookService.findByPriceRange(minPrice, maxPrice);
        if (books.isEmpty()) {
            throw new EntityException(
                    "No book found for this price range currently.", HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @GetMapping("/findByRate/{minRate}")
    public List<Book> findByRate(@PathVariable float minRate) {
        List<Book> books = bookService.findByRate(minRate);
        if (books.isEmpty()) {
            throw new EntityException(
                    "No book found for this rate currently.", HttpStatus.NOT_FOUND);
        }
        return books;
    }

    @PostMapping
    public Book add(@Valid @RequestBody Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityException(
                    "Please fill the information correctly.", HttpStatus.BAD_REQUEST);
        }
        return bookService.add(book);
    }

    @PutMapping
    public Book update(@Valid @RequestBody Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new EntityException(
                    "Please fill the information correctly.", HttpStatus.BAD_REQUEST);
        }
        return bookService.update(book);
    }

    @DeleteMapping("/{bookId}")
    public Book delete(@PathVariable int bookId) {
        Book deletedBook = bookService.findOne(bookId);
        if (deletedBook == null) {
            throw new EntityException(
                    "Book not found. Please check everything again.", HttpStatus.NOT_FOUND);
        }
        return bookService.delete(deletedBook);
    }

}
