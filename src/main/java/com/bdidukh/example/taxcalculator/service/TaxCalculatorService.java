package com.bdidukh.example.taxcalculator.service;

import com.bdidukh.example.taxcalculator.model.goods.Goods;
import com.bdidukh.example.taxcalculator.model.TaxAccumulator;
import com.bdidukh.example.taxcalculator.service.rate.TaxedRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaxCalculatorService {

    private final List<TaxedRate> taxedRateList;

    private static final BigDecimal increment = new BigDecimal(0.05);

    @Autowired
    public TaxCalculatorService(List<TaxedRate> taxedRateList) {
        this.taxedRateList = taxedRateList;
    }

    public Optional<BigDecimal> calculateTax(Goods[] input) {

        Optional<BigDecimal> tax = Arrays.stream(input)
                .map(g -> new TaxAccumulator(g, taxedRateList))
                .map(t -> (t.getTaxes()))
                .reduce(BigDecimal::add)
                .map(TaxCalculatorService::round);

        return tax;
    }

    private static BigDecimal round(BigDecimal taxBD) {

        BigDecimal divided = taxBD.divide(increment, 0, RoundingMode.UP);
        BigDecimal result = divided.multiply(increment);
        result = result.setScale(2, BigDecimal.ROUND_HALF_UP);

        return result;
    }
}
