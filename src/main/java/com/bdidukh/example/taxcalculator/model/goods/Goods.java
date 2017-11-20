package com.bdidukh.example.taxcalculator.model.goods;

import java.math.BigDecimal;

public class Goods {

    private Category category;
    private String description;
    private int count;
    private BigDecimal unitPrice;
    private boolean imported;

    public Goods() {
    }

    public Goods(Category category, String description, int count, BigDecimal unitPrice, boolean imported) {
        this.category = category;
        this.description = description;
        this.count = count;
        this.unitPrice = unitPrice;
        this.imported = imported;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "category=" + category +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", unitPrice=" + unitPrice +
                ", imported=" + imported +
                '}';
    }
}
