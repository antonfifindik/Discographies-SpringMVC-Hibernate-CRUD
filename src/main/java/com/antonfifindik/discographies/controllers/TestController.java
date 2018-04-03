package com.antonfifindik.discographies.controllers;

import com.antonfifindik.discographies.models.Albums;
import com.antonfifindik.discographies.models.Genres;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Антон on 31.03.2018.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {


        return "test";
    }


}
