package com.sp.rest;

import com.sp.model.Market;
import com.sp.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarketRestCrt {
    @Autowired
    MarketService mService;

    @RequestMapping(method = RequestMethod.POST, value = "/market-rest")
    public void addMarket(@RequestBody Market market) {
        mService.addMarket(market);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/market-rest")
    public Iterable<Market> getAllMarket() {
        return mService.getAllMarket();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/market-rest/{id}")
    public void deleteMarket(@RequestBody Integer id) {
        mService.deleteMarket(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/market-rest/{id}")
    public void updateMarket(@PathVariable String id) {
        mService.getMarket(Integer.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/market-rest/{id}/{buyerId}")
    public void buyMarket(@PathVariable String id, @PathVariable String buyerId) {
        mService.buyMarket(Integer.valueOf(id), Integer.valueOf(buyerId));
    }
}
