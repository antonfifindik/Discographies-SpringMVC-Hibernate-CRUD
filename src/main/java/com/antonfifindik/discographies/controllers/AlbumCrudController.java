package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 30.03.2018.
 */
@Controller
public class AlbumCrudController {

    @Autowired
    AlbumsService albumsService;
    @Autowired
    AlbumTypesService albumTypesService;
    @Autowired
    AuthorsService authorsService;
    @Autowired
    AuthorTypesService authorTypesService;
    @Autowired
    GenresService genresService;
    @Autowired
    LabelsService labelsService;
    @Autowired
    MusiciansService musiciansService;
    @Autowired
    ProducersService producersService;
    @Autowired
    RecordTypesService recordTypesService;
    @Autowired
    SongsService songsService;

    @RequestMapping(value = "/addAlbum", method = RequestMethod.GET)
    @Transactional
    public String addAlbumPage(Model model) {
        model.addAttribute("albumTypesList", albumTypesService.list());
        model.addAttribute("authorsList", authorsService.list());
        model.addAttribute("genresList", genresService.list());
        model.addAttribute("labelsList", labelsService.list());
        model.addAttribute("producersList", producersService.list());
        model.addAttribute("recordTypesList", recordTypesService.list());

        return "addAlbum";
    }

    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    @Transactional
    public String addAlbum(HttpServletRequest request) {

        //for test
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("author"));
        System.out.println(request.getParameter("releaseDate"));
        System.out.println(request.getParameter("length"));
        System.out.println(request.getParameter("albumType"));
        System.out.println(request.getParameter("recordType"));
        System.out.println(request.getParameter("genre"));
   //     System.out.println(request.getIn);
        System.out.println(request.getParameter("description"));
        return "redirect:/home";
    }

}
