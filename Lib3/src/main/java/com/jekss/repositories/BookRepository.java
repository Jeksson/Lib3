package com.jekss.repositories;

import com.jekss.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by Жека on 22.07.2015.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select u from Book u where u.name=?1 ")
    Book search(String name);
}
