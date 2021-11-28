package com.vinaylogics.microservices.currencyexchangeservice.services.impl;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.vinaylogics.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import com.vinaylogics.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository repository;

    public CurrencyExchangeServiceImpl(CurrencyExchangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CurrencyExchange findByFromAndTo(String from, String to) {
        return repository.findByFromAndTo(from,to).orElseThrow(()-> new RuntimeException("Unable to find data for "
                + from + " to " + to));
    }
}
