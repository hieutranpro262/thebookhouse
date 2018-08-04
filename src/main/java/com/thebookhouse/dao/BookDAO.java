package com.thebookhouse.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.thebookhouse.model.Book;

@Repository
public class BookDAO {

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(
                1, "Fear: Trump in the White House", 1, 1, 1, 24.99f, 5.0f, 1));
        books.add(new Book(2, "The Subtle Art of Not Giving a F*ck",
                1, 1, 1, 24.99f, 5.0f, 1));

        return books;
    }
}
