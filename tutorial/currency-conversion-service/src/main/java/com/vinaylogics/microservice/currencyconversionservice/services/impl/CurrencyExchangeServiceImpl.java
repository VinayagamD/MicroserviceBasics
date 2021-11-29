package com.vinaylogics.microservice.currencyconversionservice.services.impl;

import com.vinaylogics.microservice.currencyconversionservice.configs.CurrencyExchangeProxy;
import com.vinaylogics.microservice.currencyconversionservice.models.CurrencyConversion;
import com.vinaylogics.microservice.currencyconversionservice.services.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeProxy proxy;

    public CurrencyExchangeServiceImpl(CurrencyExchangeProxy proxy) {
        this.proxy = proxy;
    }


    @Override
    public CurrencyConversion getCalculatedCurrencyConversion(String from, String to, BigDecimal quantity) {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariables);
        CurrencyConversion currencyConversion  = responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
                currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment());
    }

    @Override
    public CurrencyConversion getCalculatedFeignCurrencyConversion(String from, String to, BigDecimal quantity) {
        CurrencyConversion currencyConversion  = proxy.retrieveExchangeValue(from,to);
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
                currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()+" feign");
    }
}
