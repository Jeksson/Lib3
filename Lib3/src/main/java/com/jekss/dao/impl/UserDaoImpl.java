package com.jekss.dao.impl;

import com.jekss.dao.UserDao;
import com.jekss.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Жека on 21.07.2015.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User createAndRedact(User user) {
        if(user.getId() <= 0){
            em.persist(user);
        } else {
            user = em.merge(user);
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User login(String email, String password) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.email=?1 and u.password=?2", User.class);
        query.setParameter(1, email);
        query.setParameter(2, password);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException |NoResultException e) {
            return null;
        }
    }
}
