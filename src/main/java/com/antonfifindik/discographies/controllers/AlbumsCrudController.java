package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.*;
import com.antonfifindik.discographies.models.*;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Антон on 30.03.2018.
 */
@Controller
public class AlbumsCrudController {

    @Autowired
    private AlbumsService albumsService;
    @Autowired
    private AlbumTypesService albumTypesService;
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private GenresService genresService;
    @Autowired
    private LabelsService labelsService;
    @Autowired
    private ProducersService producersService;
    @Autowired
    private RecordTypesService recordTypesService;
    @Autowired
    private SongsService songsService;

    @RequestMapping(value = "/addAlbum", method = RequestMethod.GET)
    @Transactional
    public String addAlbumPage(Model model) {
        model.addAttribute("albumTypesList", albumTypesService.list());
        model.addAttribute("authorsList", authorsService.list());
        model.addAttribute("genresList", genresService.list());
        model.addAttribute("labelsList", labelsService.list());
        model.addAttribute("producersList", producersService.list());
        model.addAttribute("recordTypesList", recordTypesService.list());
        //     model.addAttribute("songsList", songsService.list().stream().filter((s) -> s.getAlbum() == null).toArray());
        List<Songs> unselectedSongs = new ArrayList<Songs>();
        for (Songs song : songsService.list())
            if (song.getAlbum() == null)
                unselectedSongs.add(song);

        model.addAttribute("songsList", unselectedSongs);

        return "addAlbum";
    }

    @RequestMapping(value = "/addAlbum", method = RequestMethod.POST)
    @Transactional
    public String addAlbum(HttpServletRequest request, @RequestParam("cover") MultipartFile cover) {

        //TODO ...

        return "redirect:/home";
    }

}
