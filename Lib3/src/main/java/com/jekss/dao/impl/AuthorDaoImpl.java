package com.jekss.dao.impl;

import com.jekss.dao.AuthorDao;
import com.jekss.entities.Author;
import com.jekss.entities.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Жека on 21.07.2015.
 */
@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll() {
        return em.createQuery("select u from Author u", Author.class).getResultList();
    }

    @Override
    public List<Book> getListBooksAutor(int id) {
        return findAuthorById(id).getBooks();
    }

    @Override
    public Author create(Author author) {
        if((author.getFirstName() != null)& (author.getLastName() != null)) {
            if (author.getId() <= 0) {
                em.persist(author);
            }
        }
        return author;
    }

    @Override
    public Author update(Author author) {
        return em.merge(author);
    }

    @Override
    public Author search(String firstName, String lastName) {
        TypedQuery<Author> query = em.createQuery("select u from Author u where u.firstName=?1 and u.lastName=?2", Author.class);
        query.setParameter(1, firstName);
        query.setParameter(2, lastName);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException |NoResultException e) {
            return null;
        }
    }

    @Override
    public Author findAuthorById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public void remove(Author author) {
        em.remove(author);
    }
}
