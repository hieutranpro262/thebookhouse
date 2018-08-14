package com.thebookhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebookhouse.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
