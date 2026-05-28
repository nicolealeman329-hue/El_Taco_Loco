package toppings;

import enums.RegularToppingType;
import enums.TacoSize;

public class RegularTopping extends Topping {
    public RegularTopping(RegularToppingType type) {
        super(type.toString(), false);
    }

    @Override
    public double getPrice(TacoSize size) {
        return 0;
    }
}
