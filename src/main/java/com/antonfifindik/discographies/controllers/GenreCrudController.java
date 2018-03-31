package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Антон on 31.03.2018.
 */
@Controller
public class GenreCrudController {

    @Autowired
    GenresService genresService;

    @RequestMapping(value = "/addGenre", method = RequestMethod.POST)
    @Transactional
    public String addAlbum(HttpServletRequest request) {

        System.out.println(request.getParameter("genreName"));
        System.out.println(request.getParameter("genreDescription"));
        return "redirect:/addAlbum";
    }

}
