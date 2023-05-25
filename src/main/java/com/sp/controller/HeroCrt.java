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
public class HeroCrt {
    public HeroService heroService;
    public HeroCrt(HeroService heroService) {
        super();
        this.heroService = heroService;
    }

    @RequestMapping(method = RequestMethod.GET, value="/create-hero")
    public String sayHello(Model model) {
        HeroFormDto heroForm = new HeroFormDto();
        model.addAttribute("heroForm", heroForm);
        return "create_hero";
    }

    @RequestMapping(method = RequestMethod.POST, value="/create-hero")
    public String sayHello(Model model, @ModelAttribute("poneyForm") HeroFormDto heroForm) {
        Hero hero = new Hero(heroForm.getName(), heroForm.getDescription(), heroForm.getImgUrl(), heroForm.getHp(), heroForm.getAttack(), heroForm.getDefense(), heroForm.getEnergy());
        model.addAttribute("hero", this.heroService.addHero(hero));
        return "hero_detail";
    }
}
