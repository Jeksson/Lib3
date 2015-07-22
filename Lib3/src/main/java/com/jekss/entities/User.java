package com.jekss.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Жека on 09.07.2015.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private int id;
    private String email;
    private String name;
    private String password;
    private Set<RoleUsers> roleUsers = new HashSet<>();

    public User() {
    }

    public User(int id, String email,String name, String password, Set<RoleUsers> roleUsers) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roleUsers = roleUsers;
    }


    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    public Set<RoleUsers> getRoleUsers() {
        return roleUsers;
    }

    public void setRoleUsers(Set<RoleUsers> roleUsers) {
        this.roleUsers = roleUsers;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue()
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
