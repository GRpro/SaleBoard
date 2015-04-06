package com.saleboard.dao;

import com.saleboard.entities.Board;
import com.saleboard.entities.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BoardDAO implements CRUD<Board> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Board object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        return object.getId();
    }

    @Override
    public Board get(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Board) session.get(Board.class, id);
    }

    @Override
    public List<Board> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Board.class).list();
    }

    @Override
    public void update(Board object) {

    }

    @Override
    public void delete(Board object) {

    }
}
