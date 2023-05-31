package com.sp.service;

import com.sp.model.Market;
import com.sp.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MarketService {
    @Autowired
    MarketRepository mRepository;

    public Market addMarket(Market m) {
        return mRepository.save(m);
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
}
