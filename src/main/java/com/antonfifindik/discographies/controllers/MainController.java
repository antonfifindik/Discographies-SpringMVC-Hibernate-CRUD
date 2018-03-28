package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.models.AlbumTypes;
import com.antonfifindik.discographies.models.Albums;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Антон on 25.03.2018.
 */

@Controller
public class MainController {

    //for test
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String helloWorld() {

//        Session session = sessionFactory.getCurrentSession();
//        List<Albums> albumsList = session.createQuery("FROM Albums").list();
//
//        for(Albums album : albumsList)
//            System.out.println(album.getName());

        System.out.println("ААААААААААААААААААААААААААААААААААААААА");

        return "index";
    }

}
