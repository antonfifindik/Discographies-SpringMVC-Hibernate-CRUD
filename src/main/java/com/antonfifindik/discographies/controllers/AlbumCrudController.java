package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.*;
import com.antonfifindik.discographies.models.AlbumTypes;
import com.antonfifindik.discographies.models.AuthorTypes;
import com.antonfifindik.discographies.models.Authors;
import com.antonfifindik.discographies.models.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addAlbum(Model model) {
        model.addAttribute("albumTypesList", albumTypesService.list());
        model.addAttribute("authorsList", authorsService.list());
        model.addAttribute("genresList", genresService.list());
        model.addAttribute("labelsList", labelsService.list());
        model.addAttribute("producersList", producersService.list());
        model.addAttribute("recordTypesList", recordTypesService.list());

        return "addAlbum";
    }

}
