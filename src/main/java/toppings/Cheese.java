package toppings;

import enums.CheeseType;
import enums.TacoSize;

public class Cheese extends Topping {
    public Cheese(CheeseType type, boolean extra) {
        super(type.toString(), extra);
    }

    @Override
    public double getPrice(TacoSize size) {
        switch (size) {
            case SINGLE:
                return extra ? 1.05 : 0.75;
            case THREE_TACO:
                return extra ? 2.10 : 1.50;
            case BURRITO:
                return extra ? 3.15 : 2.25;
            default:
                return 0;
        }
    }
}
