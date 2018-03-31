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
    private AuthorTypesService authorTypesService;
    @Autowired
    private GenresService genresService;
    @Autowired
    private LabelsService labelsService;
    @Autowired
    private MusiciansService musiciansService;
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

        Albums newAlbum = new Albums();
        newAlbum.setName(request.getParameter("name"));
        newAlbum.setAuthor(authorsService.getById(Long.parseLong(request.getParameter("author"))));
        String[] dateArray = request.getParameter("releaseDate").split("-");

        newAlbum.setReleaseDate(new Date(Integer.parseInt(dateArray[2]) - 1900, Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])));

        newAlbum.setLength(request.getParameter("length"));
        newAlbum.setAlbumType(albumTypesService.getById(Long.parseLong(request.getParameter("albumType"))));
        newAlbum.setRecordType(recordTypesService.getById(Long.parseLong(request.getParameter("recordType"))));

        Set<Songs> songsSet = new HashSet<Songs>();
        for (String id : request.getParameterValues("song"))
            songsSet.add(songsService.getById(Long.parseLong(id)));

        newAlbum.setSongs(songsSet);

        Set<Genres> genresSet = new HashSet<Genres>();
        for (String id : request.getParameterValues("genre"))
            genresSet.add(genresService.getById(Long.parseLong(id)));

        newAlbum.setGenres(genresSet);

        Set<Labels> labelsSet = new HashSet<Labels>();
        for (String id : request.getParameterValues("label"))
            labelsSet.add(labelsService.getById(Long.parseLong(id)));

        newAlbum.setLabels(labelsSet);

        Set<Producers> producersSet = new HashSet<Producers>();
        for (String id : request.getParameterValues("producer"))
            producersSet.add(producersService.getById(Long.parseLong(id)));

        newAlbum.setProducers(producersSet);

        try {
            newAlbum.setCover(cover.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        newAlbum.setDescription(request.getParameter("description"));

        albumsService.save(newAlbum);

        return "redirect:/home";
    }

}
