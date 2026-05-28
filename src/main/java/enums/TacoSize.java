package enums;

public enum TacoSize {
    SINGLE("Single Taco"),
    THREE_TACO("3-Taco Plate"),
    BURRITO("Burrito");

    private final String displayName;

    TacoSize(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
