package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.interfaces.LabelsService;
import com.antonfifindik.discographies.models.Labels;
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
public class LabelsCrudController {

    @Autowired
    LabelsService labelsService;

    @RequestMapping(value = "/addLabel", method = RequestMethod.POST)
    public String addAlbum(HttpServletRequest request, @RequestParam("labelImage") MultipartFile labelImage) {

        Labels newLabel = new Labels();
        newLabel.setName(request.getParameter("labelName"));
        newLabel.setDescription(request.getParameter("labelDescription"));
        try {
            newLabel.setPhoto(labelImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        labelsService.save(newLabel);

        return "redirect:/addAlbum";
    }

}
