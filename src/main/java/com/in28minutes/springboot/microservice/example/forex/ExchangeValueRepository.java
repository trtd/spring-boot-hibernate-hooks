package com.in28minutes.springboot.microservice.example.forex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ExchangeValueRepository extends 
    JpaRepository<ExchangeValue, Long>{
  ExchangeValue findByFromAndTo(String from, String to);

  @Modifying
  @Query("update ExchangeValue e set e.conversionMultiple = :rate where e.id = :id")
  void updateConversionMultiple(@Param("rate") BigDecimal conversionMultiple, @Param("id") Long id);
}