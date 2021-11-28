package com.vinaylogics.microservices.currencyexchangeservice.controllers;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.vinaylogics.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeService service;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService service) {
        this.environment = environment;
        this.service = service;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange = service.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
