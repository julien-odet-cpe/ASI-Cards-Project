package com.sp.repository;

import com.sp.model.Market;
import org.springframework.data.repository.CrudRepository;

public interface MarketRepository extends CrudRepository<Market, Integer> {

    public Market findByHeroId(Integer heroId);
}
