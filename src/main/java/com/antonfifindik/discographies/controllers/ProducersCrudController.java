package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.ProducersService;
import com.antonfifindik.discographies.models.Labels;
import com.antonfifindik.discographies.models.Producers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Антон on 31.03.2018.
 */
@Controller
public class ProducersCrudController {

    @Autowired
    ProducersService producersService;

    @RequestMapping(value = "/addProducer", method = RequestMethod.POST)
    public String addAlbum(HttpServletRequest request, @RequestParam("producerImage") MultipartFile producerImage) {

        Producers newProducer = new Producers();
        newProducer.setFirstName(request.getParameter("producerFirstName"));
        newProducer.setLastName(request.getParameter("producerLastName"));
        newProducer.setDescription(request.getParameter("producerDescription"));

        try {
            newProducer.setPhoto(producerImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        producersService.save(newProducer);

        return "redirect:/addAlbum";
    }

}
