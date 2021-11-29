package com.vinaylogics.microservice.currencyconversionservice.services;

import com.vinaylogics.microservice.currencyconversionservice.models.CurrencyConversion;

import java.math.BigDecimal;

public interface CurrencyExchangeService {
    CurrencyConversion getCalculatedCurrencyConversion(String from, String to, BigDecimal quantity);
    CurrencyConversion getCalculatedFeignCurrencyConversion(String from, String to, BigDecimal quantity);

}
