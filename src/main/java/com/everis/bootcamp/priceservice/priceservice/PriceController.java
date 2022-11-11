package com.everis.bootcamp.priceservice.priceservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private Logger log = LoggerFactory.getLogger(PriceController.class);

    @Autowired
    private PriceService service;

    @GetMapping
    public List<Price> getAllPrices(){
        return this.service.findAll();
    }

    @GetMapping("/{idProduct}")
    public Price getPrice(@PathVariable("idProduct") Integer id){
        Price price = new Price();
        try {
            price = this.service.findOne(id);
        }catch(PriceNotFoundException e){
            log.error(e.getMessage());
        }finally{
            return price;
        }
    }

    @PostMapping
    public Price newPrice(@RequestBody Price price){
        Price newPrice = new Price();
        try{
            this.service.findOne(price.getProductId());
        }catch(PriceNotFoundException e){
            newPrice = this.service.insert(price);
        }
        return newPrice;
    }
}
