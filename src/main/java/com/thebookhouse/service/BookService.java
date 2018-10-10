package com.thebookhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebookhouse.model.Book;
import com.thebookhouse.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByType(int bookTypeId) {
        return bookRepository.findByType(bookTypeId);
    }

    public List<Book> findByAuthor(int authorId) {
        return bookRepository.findByAuthor(authorId);
    }

    public List<Book> findByCompany(int companyId) {
        return bookRepository.findByCompany(companyId);
    }

    public List<Book> findByPriceRange(float minPrice, float maxPrice) {
        return bookRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Book> findByRate(float minRate) {
        return bookRepository.findByRate(minRate);
    }

    public Book add(Book book) {
        book.setId(0);
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public Book delete(Book book) {
        bookRepository.delete(book);
        return book;
    }

}
