package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.dao.DaoException;
import com.antonfifindik.discographies.interfaces.AlbumsService;
import com.antonfifindik.discographies.interfaces.AuthorsService;
import com.antonfifindik.discographies.interfaces.GenresService;
import com.antonfifindik.discographies.interfaces.SongsService;
import com.antonfifindik.discographies.models.Albums;
import com.antonfifindik.discographies.models.Authors;
import com.antonfifindik.discographies.models.Genres;
import com.antonfifindik.discographies.models.Songs;
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
    private AuthorsService authorsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String helloWorld() {

        Authors author = authorsService.getById(1L);
        System.out.println(author);

        return "home";
    }
}
