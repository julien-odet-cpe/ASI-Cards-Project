package com.sp.rest;

import com.sp.model.Hero;
import com.sp.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeroRestCrt {
    @Autowired
    HeroService hService;

    @RequestMapping(method = RequestMethod.POST, value = "/hero")
    public void addHero(@RequestBody Hero hero) {
        hService.addHero(hero);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hero/{id}")
    public Hero getHero(@PathVariable String id) {
        Hero h = hService.getHero(Integer.valueOf(id));
        return h;
    }
}
