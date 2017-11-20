package com.bdidukh.example.taxcalculator.service.rate;

import com.bdidukh.example.taxcalculator.controller.TaxConfig;
import com.bdidukh.example.taxcalculator.model.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ImportTaxedRate implements TaxedRate {

    private final TaxConfig taxConfig;

    @Autowired
    public ImportTaxedRate(TaxConfig taxConfig) {
        this.taxConfig = taxConfig;
    }

    @Override
    public BigDecimal taxPercent() {
        return taxConfig.getTaxImport();
    }

    @Override
    public boolean taxApplicable(Goods item) {
        return item.isImported();
    }
}
