package com.bdidukh.example.taxcalculator.controller;


import com.bdidukh.example.taxcalculator.model.goods.Goods;
import com.bdidukh.example.taxcalculator.model.response.TaxedResponse;
import com.bdidukh.example.taxcalculator.service.TaxCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class TaxesController {

    private final TaxCalculatorService calculatorService;

    @Autowired
    public TaxesController(TaxCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public ResponseEntity<TaxedResponse> uploadFile(@RequestBody Goods[] input) {

        Optional<BigDecimal> taxCalculated = calculatorService.calculateTax(input);

        TaxedResponse taxed = new TaxedResponse(taxCalculated.orElse(BigDecimal.ZERO));

        return ResponseEntity.ok().body(taxed);
    }
}
