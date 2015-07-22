package com.jekss.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Жека on 09.07.2015.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

    private int id;
    private String name;
    private String description;
    private int age;

    public Book(int id, String name, String description, int age, List<Author> authors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.age = age;
        this.authors = authors;
    }

    public Book() {

    }


    @Id
    @Column(name = "id")
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (age != book.age) return false;
        if (id != book.id) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
