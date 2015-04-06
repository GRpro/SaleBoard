package com.saleboard.service;


import com.saleboard.dao.*;
import com.saleboard.entities.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderingService {

    @Autowired
    private OrderingDAO orderingDAO;
    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private SailDAO sailDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private TrainerDAO trainerDAO;

    public long create(Ordering object, long boardId, long sailId, long trainerId, long tariffId) {
        object.setBoard(boardDAO.get(boardId));
        object.setSail(sailDAO.get(sailId));
        object.setTariff(tariffDAO.get(tariffId));
        object.setTrainer(trainerDAO.get(trainerId));
        return orderingDAO.create(object);
    }

    public Ordering get(long id) {
        return orderingDAO.get(id);
    }

    public List<Ordering> getAll() {
        return orderingDAO.getAll();
    }

    public void update(Ordering object) {
        orderingDAO.update(object);
    }

    public void delete(Ordering object) {
        orderingDAO.delete(object);
    }
}
