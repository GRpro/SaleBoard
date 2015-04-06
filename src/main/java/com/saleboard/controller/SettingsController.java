package com.saleboard.controller;

import com.saleboard.dao.BoardDAO;
import com.saleboard.dao.SailDAO;
import com.saleboard.dao.TariffDAO;
import com.saleboard.dao.TrainerDAO;
import com.saleboard.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/settings")
public class SettingsController {

    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private SailDAO sailDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private TrainerDAO trainerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView settingsPage() {
        ModelAndView modelAndView = new ModelAndView("settings");
        return modelAndView;
    }

    @RequestMapping(value = "/board", method = RequestMethod.POST)
    public ModelAndView newBoard(@ModelAttribute("board")Board board) {
        ModelAndView modelAndView;
        try {
            long id = boardDAO.create(board);
            modelAndView = new ModelAndView("success/success");
            modelAndView.addObject("message", "Board with id " + id + " was successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("error/error");
            modelAndView.addObject("message", "Attempt to register new board was unsuccessful");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/sail", method = RequestMethod.POST)
    public ModelAndView newSail(@ModelAttribute("sail")Sail sail) {
        ModelAndView modelAndView;
        try {
            long id = sailDAO.create(sail);
            modelAndView = new ModelAndView("success/success");
            modelAndView.addObject("message", "Sail with id " + id + " was successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("error/error");
            modelAndView.addObject("message", "Attempt to register new sail was unsuccessful");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/tariff", method = RequestMethod.POST)
    public ModelAndView newTariff(@ModelAttribute("tariff")Tariff tariff) {
        ModelAndView modelAndView;
        try {
            long id = tariffDAO.create(tariff);
            modelAndView = new ModelAndView("success/success");
            modelAndView.addObject("message", "Tariff with id " + id + " was successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("error/error");
            modelAndView.addObject("message", "Attempt to register new tariff was unsuccessful");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    public ModelAndView newTrainer(@ModelAttribute("trainer")Trainer trainer) {
        ModelAndView modelAndView;
        try {
            long id = trainerDAO.create(trainer);
            modelAndView = new ModelAndView("success/success");
            modelAndView.addObject("message", "Trainer with id " + id + " was successfully added");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("error/error");
            modelAndView.addObject("message", "Attempt to register new trainer was unsuccessful");
        }
        return modelAndView;
    }



}
