package com.bdidukh.example.taxcalculator.service.rate;

import com.bdidukh.example.taxcalculator.model.goods.Goods;

import java.math.BigDecimal;

public interface TaxedRate {

    BigDecimal taxPercent();

    boolean taxApplicable(Goods item);
}
