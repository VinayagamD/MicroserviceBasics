package com.vinaylogics.microservices.currencyexchangeservice.services;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;

public interface CurrencyExchangeService {
    CurrencyExchange findByFromAndTo(String from, String to);
}
