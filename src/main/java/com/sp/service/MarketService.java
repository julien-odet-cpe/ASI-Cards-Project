package com.sp.service;

import com.sp.model.Market;
import com.sp.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketRepository mRepository;

    public Market addMarket(Market m) {
        Market newMarket = new Market(m.getHeroId(), m.getSellerId(), m.getPrice());
        return mRepository.save(newMarket);
    }

    public Market getMarket(Integer id) {
        return mRepository.findById(id).orElse(null);
    }

    public Market buyMarket(Integer id, Integer buyerId) {
        Market m = mRepository.findById(id).orElse(null);
        assert m != null;
        m.setBuyerId(buyerId);
        m.setSoldDate(new Date());
        return mRepository.save(m);
    }

    public Iterable<Market> getAllMarket() {
        return mRepository.findAll();
    }

    public void deleteMarket(Integer id) {
        mRepository.deleteById(id);
    }

    public void deleteMarketByHeroId(Integer heroId) {
        Market m = mRepository.findByHeroId(heroId);
        mRepository.deleteById(m.getId());
    }

    public Iterable<Market> getOpenMarket() {
        List<Market> markets = new LinkedList<Market>();
        for (Market m : mRepository.findAll()) {
            if (m.getBuyerId() == null) {
                markets.add(m);
            }
        }
        return markets;
    }

    public Iterable<Market> getOpenMarketBySellerId(Integer sellerId) {
        List<Market> markets = new LinkedList<Market>();
        Iterable<Market> mA = mRepository.findBySellerId(sellerId);
        for (Market m : mA) {
            if (m.getBuyerId() == null) {
                markets.add(m);
            }
        }
        return markets;
    }
}
