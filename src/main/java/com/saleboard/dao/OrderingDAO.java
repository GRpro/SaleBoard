package com.saleboard.dao;

import com.saleboard.entities.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderingDAO implements CRUD<Ordering> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Ordering object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        return object.getId();
    }

    @Override
    public Ordering get(long id) {
        return null;
    }

    @Override
    public List<Ordering> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Ordering.class).list();
    }

    @Override
    public void update(Ordering object) {

    }

    @Override
    public void delete(Ordering object) {

    }
}
