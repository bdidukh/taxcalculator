package com.bdidukh.example.taxcalculator.model.goods;

public enum Category {

    FOOD(false), DRUGS(false), BOOK(false), MUSIC(true), BEAUTY(true);

    Category(boolean taxed) {
        this.taxed = taxed;
    }

    private boolean taxed;

    public boolean isTaxed() {
        return taxed;
    }

    public void setTaxed(boolean taxed) {
        this.taxed = taxed;
    }
}
