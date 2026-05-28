package model;

import enums.DrinkSize;

public class Drink implements MenuItem {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        switch (size) {
            case SMALL:
                return 2.00;
            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
            default:
                return 0;
        }
    }

    @Override
    public String getReceiptText() {
        return size + " Drink (" + flavor + ") - $" + String.format("%.2f", getPrice());
    }
}
