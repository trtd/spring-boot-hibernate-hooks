package com.in28minutes.springboot.microservice.example.forex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class ForexController {
  
  @Autowired
  private Environment environment;
  
  @Autowired
  private ExchangeValueRepository repository;
  
  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue retrieveExchangeValue
    (@PathVariable String from, @PathVariable String to){
    
    ExchangeValue exchangeValue = 
        repository.findByFromAndTo(from, to);
    
    exchangeValue.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));
    
    return exchangeValue;
  }

  @Transactional
  @PutMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeValue updateExchangeValue
          (@PathVariable String from, @PathVariable String to, @RequestBody UpdateRate rate){

    ExchangeValue exchangeValue =
            repository.findByFromAndTo(from, to);

    exchangeValue.setConversionMultiple(rate.getConversionMultiple());
    repository.updateConversionMultiple(exchangeValue.getConversionMultiple(), exchangeValue.getId());
    exchangeValue.setPort(
            Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }

  @Transactional
  @PostMapping("/currency-exchange")
  public ExchangeValue addExchangeValue(@RequestBody ExchangeValue exchangeValue) {

    ExchangeValue existing = repository.findByFromAndTo(exchangeValue.getFrom(), exchangeValue.getTo());
    if (existing != null) {
      return updateExchangeValue(exchangeValue.getFrom(), exchangeValue.getTo(),
              new UpdateRate(exchangeValue.getConversionMultiple()));
    }

    repository.saveAndFlush(exchangeValue);
    exchangeValue.setPort(
            Integer.parseInt(environment.getProperty("local.server.port")));

    return exchangeValue;
  }
}