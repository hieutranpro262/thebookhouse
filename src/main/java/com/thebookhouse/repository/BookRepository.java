package com.thebookhouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thebookhouse.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE b.type.id = ?1")
    List<Book> findByType(int bookTypeId);

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1")
    List<Book> findByAuthor(int authorId);

    @Query("SELECT b FROM Book b WHERE b.company.id = ?1")
    List<Book> findByCompany(int companyId);

    @Query("SELECT b FROM Book b WHERE b.price >= ?1 and b.price <= ?2")
    List<Book> findByPriceRange(float minPrice, float maxPrice);

    @Query("SELECT b FROM Book b WHERE b.rate >= ?1")
    List<Book> findByRate(float minRate);

}
