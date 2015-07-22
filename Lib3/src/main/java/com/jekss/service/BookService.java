package com.jekss.service;

import com.jekss.entities.Book;
import com.jekss.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Жека on 22.07.2015.
 */
@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(int id) {
        return bookRepository.findOne(id);
    }

    public Book search(String name) {
        return bookRepository.search(name);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public void delete(int id) {
        bookRepository.delete(id);
    }
}
