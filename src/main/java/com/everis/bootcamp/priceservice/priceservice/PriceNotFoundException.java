package com.everis.bootcamp.priceservice.priceservice;

public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(Integer id) {
        super("Precio no encontrado : " + id);
    }
}
