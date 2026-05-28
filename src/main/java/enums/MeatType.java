package enums;

public enum MeatType {
    CARNE_ASADA("Carne Asada"),
    AL_PASTOR("Al Pastor"),
    CARNITAS("Carnitas"),
    POLLO("Pollo"),
    CHORIZO("Chorizo"),
    PESCADO("Pescado");

    private final String displayName;

    MeatType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
