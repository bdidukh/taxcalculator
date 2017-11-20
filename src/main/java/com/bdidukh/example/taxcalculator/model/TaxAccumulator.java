package com.bdidukh.example.taxcalculator.model;

import com.bdidukh.example.taxcalculator.model.goods.Goods;
import com.bdidukh.example.taxcalculator.service.rate.TaxedRate;

import java.math.BigDecimal;
import java.util.List;


public class TaxAccumulator {

    private static final BigDecimal ONE_HUNDRED_PERCENT = new BigDecimal(100);

    private BigDecimal taxes;

    public TaxAccumulator(Goods item, List<TaxedRate> taxingList) {
        taxes = calculateTax(item, taxingList);
    }

    private BigDecimal calculateTax(Goods item, List<TaxedRate> taxingList) {

        BigDecimal taxShouldBeApplied = calculateTaxApplied(item, taxingList);

        BigDecimal spendMoney = item.getUnitPrice().multiply(new BigDecimal(item.getCount()));
        return percentFrom(spendMoney, taxShouldBeApplied);

    }

    private BigDecimal calculateTaxApplied(Goods item, List<TaxedRate> taxedRateList) {
        BigDecimal val = BigDecimal.ZERO;
        for (TaxedRate t : taxedRateList) {
            if (t.taxApplicable(item)) {
                val = val.add(t.taxPercent());
            }
        }
        return val;
    }

    private static BigDecimal percentFrom(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(ONE_HUNDRED_PERCENT, 2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

}
