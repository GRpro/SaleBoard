package com.saleboard.dao;

import com.saleboard.entities.Board;
import com.saleboard.entities.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TrainerDAO implements CRUD<Trainer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Trainer object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        return object.getId();
    }

    @Override
    public Trainer get(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Trainer) session.get(Trainer.class, id);
    }

    @Override
    public List<Trainer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Trainer.class).list();
    }

    @Override
    public void update(Trainer object) {

    }

    @Override
    public void delete(Trainer object) {

    }
}
