package com.jekss.service;

import com.jekss.entities.Author;
import com.jekss.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Жека on 22.07.2015.
 */
@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author create(Author author) {
        return authorRepository.save(author);
    }

    public Author findAuthorById(int id) {
        return authorRepository.findOne(id);
    }

    public Author search(String firstName, String lastName) {
        return authorRepository.search(firstName, lastName);
    }

    public Author update(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepository.delete(id);
    }
}
