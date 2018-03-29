package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Антон on 25.03.2018.
 */

@Controller
public class MainController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public String helloWorld() {
        Session session = sessionFactory.getCurrentSession();
        List<Albums> list = session.createQuery("FROM Albums").list();

        for(Albums album : list)
            System.out.println(album);

        return "home";
    }
}
