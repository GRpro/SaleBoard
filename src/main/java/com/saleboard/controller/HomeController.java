package com.saleboard.controller;

import com.saleboard.dao.*;
import com.saleboard.entities.*;
import com.saleboard.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private OrderingService orderingService;
    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private SailDAO sailDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private TrainerDAO trainerDAO;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Ordering> orderings = orderingService.getAll();
        List<Board> boards = boardDAO.getAll();
        List<Sail> sails = sailDAO.getAll();
        List<Tariff> tariffs = tariffDAO.getAll();
        List<Trainer> trainers = trainerDAO.getAll();

        modelAndView.addObject("orderings", orderings);
        modelAndView.addObject("boards", boards);
        modelAndView.addObject("sails", sails);
        modelAndView.addObject("tariffs", tariffs);
        modelAndView.addObject("trainers", trainers);
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = "/home/ordering", method = RequestMethod.POST)
    public ModelAndView newOrdering(@RequestParam("userName") String userName,
                                    @RequestParam("price") float price,
                                    @RequestParam("paid") boolean paid,
                                    @RequestParam("startPoint") @DateTimeFormat(pattern="HH:mm") Date startPoint,
                                    @RequestParam("endPoint") @DateTimeFormat(pattern="HH:mm") Date endPoint,
                                    @RequestParam("boardId") long boardId,
                                    @RequestParam("sailId") long sailId,
                                    @RequestParam("trainerId") long trainerId,
                                    @RequestParam("tariffId") long tariffId) {
        ModelAndView modelAndView;
        try {
            System.out.println("boardId "+ boardId);
            System.out.println("sailId "+ sailId);
            Ordering ordering = new Ordering();

            ordering.setUserName(userName);
            ordering.setPrice(price);
            ordering.setPaid(paid);
            ordering.setOrderingDate(new Date());
            ordering.setStartPoint(startPoint);
            ordering.setEndPoint(endPoint);
            orderingService.create(ordering, boardId, sailId, trainerId, tariffId);

//            System.out.println(ordering);

            modelAndView = new ModelAndView("index");
            List<Ordering> orderings = orderingService.getAll();
            List<Board> boards = boardDAO.getAll();
            List<Sail> sails = sailDAO.getAll();
            List<Tariff> tariffs = tariffDAO.getAll();
            List<Trainer> trainers = trainerDAO.getAll();

            modelAndView.addObject("orderings", orderings);
            modelAndView.addObject("boards", boards);
            modelAndView.addObject("sails", sails);
            modelAndView.addObject("tariffs", tariffs);
            modelAndView.addObject("trainers", trainers);
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("error/error");
            modelAndView.addObject("message", "error was occurred while creating new ordering!");
            return modelAndView;
        }

    }
}
