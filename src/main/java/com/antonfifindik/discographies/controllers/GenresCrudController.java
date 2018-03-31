package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.GenresService;
import com.antonfifindik.discographies.models.Genres;
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
public class GenresCrudController {

    @Autowired
    GenresService genresService;

    @RequestMapping(value = "/addGenre", method = RequestMethod.POST)
    @Transactional
    public String addAlbum(HttpServletRequest request) {

        Genres newGenre = new Genres();
        newGenre.setName(request.getParameter("genreName"));
        newGenre.setDescription(request.getParameter("genreDescription"));
        genresService.save(newGenre);

        return "redirect:/addAlbum";
    }

}
