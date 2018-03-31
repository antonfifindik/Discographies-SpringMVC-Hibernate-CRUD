package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.SongsService;
import com.antonfifindik.discographies.models.Genres;
import com.antonfifindik.discographies.models.Songs;
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
public class SongsCrudController {

    @Autowired
    SongsService songsService;

    @RequestMapping(value = "/addSong", method = RequestMethod.POST)
    @Transactional
    public String addAlbum(HttpServletRequest request) {

        Songs newSong = new Songs();
        newSong.setName(request.getParameter("songName"));
        newSong.setTrackNum(Integer.parseInt(request.getParameter("songNum")));

        songsService.save(newSong);

        return "redirect:/addAlbum";
    }

}
