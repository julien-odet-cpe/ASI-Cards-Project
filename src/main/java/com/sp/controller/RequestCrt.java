package com.sp.controller;

import com.sp.model.Hero;
import com.sp.model.HeroFormDto;
import com.sp.service.HeroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestCrt {

    private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String  index(Model model) {
        model.addAttribute("messageLocal", messageLocal);
        return "index";
    }

}
