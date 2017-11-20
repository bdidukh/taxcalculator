package com.bdidukh.example.taxcalculator.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TaxConfig {

    @Value("${tax.rate.local:10}")
    private BigDecimal taxInternal;

    @Value("${tax.rate.import:5}")
    private BigDecimal taxImport;

    public BigDecimal getTaxInternal() {
        return taxInternal;
    }

    public void setTaxInternal(BigDecimal taxInternal) {
        this.taxInternal = taxInternal;
    }

    public BigDecimal getTaxImport() {
        return taxImport;
    }

    public void setTaxImport(BigDecimal taxImport) {
        this.taxImport = taxImport;
    }

}
