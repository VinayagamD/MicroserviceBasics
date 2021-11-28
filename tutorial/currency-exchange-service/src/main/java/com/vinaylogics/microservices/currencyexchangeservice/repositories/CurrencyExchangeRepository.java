package com.vinaylogics.microservices.currencyexchangeservice.repositories;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}