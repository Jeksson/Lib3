package com.jekss.dao;

import com.jekss.entities.Author;
import com.jekss.entities.Book;


import java.util.List;

/**
 * Created by Жека on 21.07.2015.
 */
public interface AuthorDao {
    public List<Author> findAll();

    public Author create(Author author);

    public Author update(Author author);

    public Author search(String firstName, String lastName);

    public Author findAuthorById(int id);

    public List<Book> getListBooksAutor(int id);

    public void remove(Author author);

}
