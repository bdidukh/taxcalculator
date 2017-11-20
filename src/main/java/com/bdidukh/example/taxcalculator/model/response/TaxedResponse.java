package com.bdidukh.example.taxcalculator.model.response;

import java.math.BigDecimal;

public final class TaxedResponse {

    private BigDecimal salesTax;

    public TaxedResponse() {
    }

    public TaxedResponse(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }
}
