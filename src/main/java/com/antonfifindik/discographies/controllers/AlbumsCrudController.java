package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Антон on 30.03.2018.
 */
@Controller
public class AlbumsCrudController {

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
    public String addAlbum(HttpServletRequest request, @RequestParam("cover") MultipartFile cover) {

        //for test
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("author"));
        System.out.println(request.getParameter("releaseDate"));
        System.out.println(request.getParameter("length"));
        System.out.println(request.getParameter("albumType"));
        System.out.println(request.getParameter("recordType"));

        for (String id : request.getParameterValues("genre"))
            System.out.print(id + ", ");
        System.out.println();

        for (String id : request.getParameterValues("label"))
            System.out.print(id + ", ");
        System.out.println();

        if (!cover.isEmpty()) {
            try {
                byte[] bytes = cover.getBytes(); // alternatively, file.getInputStream();
                System.out.println(bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println(request.getParameter("description"));
        return "redirect:/home";
    }

}
