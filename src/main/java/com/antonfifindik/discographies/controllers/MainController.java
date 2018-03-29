package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.dao.DaoException;
import com.antonfifindik.discographies.interfaces.GenresService;
import com.antonfifindik.discographies.models.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Антон on 25.03.2018.
 */

@Controller
public class MainController {

    @Autowired
    private GenresService genresService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String helloWorld() {

        for(Genres genre : genresService.list())
            System.out.println(genre);

        return "home";
    }
}
