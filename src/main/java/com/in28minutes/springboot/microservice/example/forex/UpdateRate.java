package com.in28minutes.springboot.microservice.example.forex;

import java.math.BigDecimal;

public class UpdateRate {
    private BigDecimal conversionMultiple;

    public UpdateRate() {
        // Default constructor
    }

    public UpdateRate(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
