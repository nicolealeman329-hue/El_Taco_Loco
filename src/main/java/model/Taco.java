package model;

import enums.SauceType;
import enums.ShellType;
import enums.TacoSize;
import toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Taco implements MenuItem {
    private TacoSize size;
    private ShellType shell;
    private List<Topping> toppings;
    private List<SauceType> sauces;
    private boolean covered;

    public Taco(TacoSize size, ShellType shell) {
        this.size = size;
        this.shell = shell;
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSauce(SauceType sauce) {
        sauces.add(sauce);
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    @Override
    public double getPrice() {
        double total;

        switch (size) {
            case SINGLE:
                total = 3.50;
                break;
            case THREE_TACO:
                total = 9.00;
                break;
            case BURRITO:
                total = 8.50;
                break;
            default:
                total = 0;
        }

        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }

        return total;
    }

    @Override
    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();

        sb.append(size).append(" ").append(shell).append(" - $").append(String.format("%.2f", getPrice())).append("\n");

        sb.append("Toppings:\n");
        if (toppings.isEmpty()) {
            sb.append("- None\n");
        } else {
            for (Topping topping : toppings) {
                sb.append("- ").append(topping.getName()).append("\n");
            }
        }

        sb.append("Sauces:\n");
        if (sauces.isEmpty()) {
            sb.append("- None\n");
        } else {
            for (SauceType sauce : sauces) {
                sb.append("- ").append(sauce).append("\n");
            }
        }

        if (covered) {
            sb.append("Covered in salsa and queso\n");
        }

        return sb.toString();
    }
}
