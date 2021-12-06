package com.vinaylogics.microservices.currencyexchangeservice.controllers;

import com.vinaylogics.microservices.currencyexchangeservice.entities.CurrencyExchange;
import com.vinaylogics.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final Environment environment;
    private final CurrencyExchangeService service;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService service) {
        this.environment = environment;
        this.service = service;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        logger.info("retrieveExchangeValue called with {} to {}",from,to);

        CurrencyExchange currencyExchange = service.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
