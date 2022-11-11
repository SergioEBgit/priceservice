package com.everis.bootcamp.priceservice.priceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

    @Autowired
    private PriceRepository repository;

    public Price findOne(Integer id){
        return this.repository.findById(id).orElseThrow(()->new PriceNotFoundException(id));
    }

    public List<Price> findAll(){
        return repository.findAll();
    }

    public Price insert(Price price){
        return this.repository.save(price);
    }
}
