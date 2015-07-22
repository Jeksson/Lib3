package com.jekss.dao.impl;

import com.jekss.dao.BookDao;
import com.jekss.entities.Author;
import com.jekss.entities.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Жека on 22.07.2015.
 */
@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return em.createQuery("select u from Book u", Book.class).getResultList();
    }

    @Override
    public Book create(Book book) {
        if((book.getName() != null)& (book.getDescription() !=null) & (book.getAuthors() != null)){
            if(book.getId() <= 0) {
                em.persist(book);
            }
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        return em.merge(book);
    }

    @Override
    public Book searchBook(String name) {
        TypedQuery<Book> query = em.createQuery("select u from Book u where u.email=?1 ", Book.class);
        query.setParameter(1, name);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException |NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Author> getListAutorsBook(int id) {
        return findBookById(id).getAuthors();
    }

    @Override
    public Book findBookById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void remove(Book book) {
        em.remove(book);
    }
}
