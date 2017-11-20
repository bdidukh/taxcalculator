package com.bdidukh.example.taxcalculator.service.rate;

import com.bdidukh.example.taxcalculator.controller.TaxConfig;
import com.bdidukh.example.taxcalculator.model.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LocalTaxedRate implements TaxedRate {

    private final TaxConfig taxConfig;

    @Autowired
    public LocalTaxedRate(TaxConfig taxConfig) {
        this.taxConfig = taxConfig;
    }

    @Override
    public BigDecimal taxPercent() {
        return taxConfig.getTaxInternal();
    }

    @Override
    public boolean taxApplicable(Goods g) {
        return g.getCategory().isTaxed();
    }
}
