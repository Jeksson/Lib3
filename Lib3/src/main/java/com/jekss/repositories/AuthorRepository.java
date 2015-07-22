package com.jekss.repositories;

import com.jekss.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by Жека on 22.07.2015.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select u from Author u where u.firstName=?1 and u.lastName=?2")
    Author search(String firstName, String lastName);
}
