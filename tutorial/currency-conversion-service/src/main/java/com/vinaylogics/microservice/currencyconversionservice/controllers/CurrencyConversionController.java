package com.vinaylogics.microservice.currencyconversionservice.controllers;

import com.vinaylogics.microservice.currencyconversionservice.models.CurrencyConversion;
import com.vinaylogics.microservice.currencyconversionservice.services.CurrencyExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    private final CurrencyExchangeService service;

    public CurrencyConversionController(CurrencyExchangeService service) {
        this.service = service;
    }

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
      return service.getCalculatedFeignCurrencyConversion(from, to, quantity);
    }
}
