package com.vinaylogics.microservice.currencyconversionservice.services;

import com.vinaylogics.microservice.currencyconversionservice.models.CurrencyConversion;

import java.math.BigDecimal;

public interface CurrencyExchangeService {
    CurrencyConversion getCalculatedCurrentConversion(String from, String to, BigDecimal quantity);

}
