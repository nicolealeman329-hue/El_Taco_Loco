package toppings;

import enums.TacoSize;

public abstract class Topping {
    protected String name;
    protected boolean extra;

    public Topping(String name, boolean extra) {
        this.name = name;
        this.extra = extra;
    }

    public String getName() {
        if (extra) {
            return name + " (Extra)";
        }
        return name;
    }

    public abstract double getPrice(TacoSize size);
}
