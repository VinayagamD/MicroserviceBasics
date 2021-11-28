package com.vinaylogics.microservices.currencyexchangeservice.repositories;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
}