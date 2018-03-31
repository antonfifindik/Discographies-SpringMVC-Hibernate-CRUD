package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.*;
import com.antonfifindik.discographies.models.*;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Антон on 25.03.2018.
 */

@Controller
public class MainController {

    @Autowired
    private AlbumsService albumsService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    @Transactional
    public String home(Model model) {

        List<Albums> albumsList = albumsService.list();
        model.addAttribute("albumsList", albumsList);

        return "home";
    }

}
