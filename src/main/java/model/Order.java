package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(0, item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;

        for (MenuItem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public boolean hasTaco() {
        for (MenuItem item : items) {
            if (item instanceof Taco) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidOrder() {
        if (items.isEmpty()) {
            return false;
        }

        if (!hasTaco()) {
            for (MenuItem item : items) {
                if (item instanceof Drink || item instanceof ChipsAndSalsa) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n===== ORDER =====\n");

        for (MenuItem item : items) {
            sb.append(item.getReceiptText()).append("\n\n");
        }

        sb.append("TOTAL: $").append(String.format("%.2f", getTotal()));

        return sb.toString();
    }
}
