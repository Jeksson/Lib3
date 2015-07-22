package com.jekss.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Жека on 17.07.2015.
 */
@Entity
@Table(name = "role_users")
public class RoleUsers implements Serializable {

    private int id;
    private String role;

    public RoleUsers() {
    }

    public RoleUsers(int id, String role) {
        this.id = id;
        this.role = role;
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

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleUsers)) return false;

        RoleUsers roleUsers = (RoleUsers) o;

        if (id != roleUsers.id) return false;
        if (role != null ? !role.equals(roleUsers.role) : roleUsers.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
