package com.saleboard.dao;

import com.saleboard.entities.Board;
import com.saleboard.entities.Sail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SailDAO implements CRUD<Sail> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Sail object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        return object.getId();
    }

    @Override
    public Sail get(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Sail) session.get(Sail.class, id);
    }

    @Override
    public List<Sail> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Sail.class).list();
    }

    @Override
    public void update(Sail object) {

    }

    @Override
    public void delete(Sail object) {

    }
}
