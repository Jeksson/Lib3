package com.jekss.dao;

import com.jekss.entities.Author;
import com.jekss.entities.Book;

import java.util.List;

/**
 * Created by Жека on 21.07.2015.
 */
public interface BookDao {

    public List<Book> findAll();

    public Book create(Book book);

    public Book update(Book book);

    public Book searchBook(String name);

    public Book findBookById(int id);

    public List<Author> getListAutorsBook(int id);

    public void remove(Book book);

}
