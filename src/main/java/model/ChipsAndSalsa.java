package model;

import enums.SauceType;

public class ChipsAndSalsa implements MenuItem {
    private SauceType salsa;

    public ChipsAndSalsa(SauceType salsa) {
        this.salsa = salsa;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getReceiptText() {
        return "Chips & Salsa (" + salsa + ") - $1.50";
    }
}
