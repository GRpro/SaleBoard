package com.saleboard.dao;

import com.saleboard.entities.Board;
import com.saleboard.entities.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TariffDAO implements CRUD<Tariff> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Tariff object) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(object);
        return object.getId();
    }

    @Override
    public Tariff get(long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Tariff) session.get(Tariff.class, id);
    }

    @Override
    public List<Tariff> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Tariff.class).list();
    }

    @Override
    public void update(Tariff object) {

    }

    @Override
    public void delete(Tariff object) {

    }
}
