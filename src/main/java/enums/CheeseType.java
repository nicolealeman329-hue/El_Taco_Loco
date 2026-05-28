package enums;

public enum CheeseType {
    QUESO_FRESCO("Queso Fresco"),
    OAXACA("Oaxaca"),
    COTIJA("Cotija"),
    CHEDDAR("Cheddar");

    private final String displayName;

    CheeseType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
