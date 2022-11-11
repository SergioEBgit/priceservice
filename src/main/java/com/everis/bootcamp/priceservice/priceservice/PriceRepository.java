package com.everis.bootcamp.priceservice.priceservice;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Integer> {
}
