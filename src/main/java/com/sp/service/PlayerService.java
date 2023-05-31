package com.sp.service;

import com.sp.model.Player;
import com.sp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository pRepository;

    public Player addPlayer(Player p) {
        p.setUsername(p.getUsername().toLowerCase());
        p.setMoney(500);
        return pRepository.save(p);
    }

    public Player getPlayer(int id) {
        return pRepository.findById(id);
    }

    public Player login(String username, String password) {
        return pRepository.findByUsernameAndPassword(username.toLowerCase(), password);
    }

}
