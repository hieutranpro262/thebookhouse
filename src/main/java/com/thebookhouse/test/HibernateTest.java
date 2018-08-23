package com.thebookhouse.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thebookhouse.model.BookType;

@RestController
@RequestMapping("/test")
public class HibernateTest {
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/testMerge")
    @Transactional
    public void testMerge() {
        BookType bookType = new BookType();
        bookType.setId(4);
        bookType.setType("Paris");
        bookType.setDescription("Parisss");
        entityManager.merge(bookType);
    }

}
