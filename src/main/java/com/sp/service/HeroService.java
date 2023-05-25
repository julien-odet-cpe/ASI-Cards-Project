package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Hero;
import com.sp.repository.HeroRepository;

@Service
public class HeroService {
    @Autowired
    HeroRepository hRepository;
    public Hero addHero(Hero h) {
        return hRepository.save(h);
    }

    public Hero getHero(int id) {
        Optional<Hero> hOpt =hRepository.findById(id);
        return hOpt.orElse(null);
    }

}
