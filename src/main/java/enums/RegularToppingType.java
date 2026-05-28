package enums;

public enum RegularToppingType {
    LETTUCE("Lettuce"),
    CILANTRO("Cilantro"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapeños"),
    RADISHES("Radishes"),
    PICO_DE_GALLO("Pico de Gallo"),
    GUACAMOLE("Guacamole"),
    CORN("Corn"),
    LIME_WEDGES("Lime Wedges"),
    CREMA("Crema");

    private final String displayName;

    RegularToppingType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
