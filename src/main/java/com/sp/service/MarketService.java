package com.sp.service;

import com.sp.dto.MarketHeroDto;
import com.sp.model.Hero;
import com.sp.model.Market;
import com.sp.model.Player;
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

    @Autowired
    HeroService hService;

    @Autowired
    PlayerService pService;

    public Market addMarket(Market m) {
        Market newMarket = new Market(m.getHeroId(), m.getSellerId(), m.getPrice());
        return mRepository.save(newMarket);
    }

    public Market getMarket(Integer id) {
        return mRepository.findById(id).orElse(null);
    }

    public Market buyMarket(MarketHeroDto marketHeroDto, Integer buyerId) {
        assert marketHeroDto.market != null;
        marketHeroDto.market.setBuyerId(buyerId);
        marketHeroDto.market.setSoldDate(new Date());
        mRepository.save(marketHeroDto.market);
        Player seller = pService.getPlayer(marketHeroDto.market.getSellerId());
        Player buyer = pService.getPlayer(buyerId);
        Hero hero = hService.getHero(marketHeroDto.market.getHeroId());
        seller.setMoney(seller.getMoney() + marketHeroDto.market.getPrice());
        buyer.setMoney(buyer.getMoney() - marketHeroDto.market.getPrice());
        hero.setPlayerId(buyerId);
        hService.updateHero(hero);
        pService.updatePlayer(seller);
        pService.updatePlayer(buyer);

        return marketHeroDto.market;
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

    public Iterable<MarketHeroDto> getOpenMarket() {
        List<MarketHeroDto> marketHeroDtos = new LinkedList<MarketHeroDto>();

        for (Market m : mRepository.findAll()) {
            if (m.getBuyerId() == null) {
                MarketHeroDto marketHeroDto = new MarketHeroDto();
                marketHeroDto.hero = hService.getHero(m.getHeroId());
                marketHeroDto.market = m;
                marketHeroDtos.add(marketHeroDto);
            }
        }
        return marketHeroDtos;
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
