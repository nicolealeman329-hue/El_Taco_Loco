package toppings;

import enums.MeatType;
import enums.TacoSize;

public class Meat extends Topping {
    public Meat(MeatType type, boolean extra) {
        super(type.toString(), extra);
    }

    @Override
    public double getPrice(TacoSize size) {
        switch (size) {
            case SINGLE:
                return extra ? 1.50 : 1.00;
            case THREE_TACO:
                return extra ? 3.00 : 2.00;
            case BURRITO:
                return extra ? 4.50 : 3.00;
            default:
                return 0;
        }
    }
}
