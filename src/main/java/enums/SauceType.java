package enums;

public enum SauceType {
    SALSA_VERDE("Salsa Verde"),
    SALSA_ROJA("Salsa Roja"),
    CHIPOTLE("Chipotle"),
    HABANERO("Habanero"),
    MILD("Mild"),
    EXTRA_HOT("Extra Hot");

    private final String displayName;

    SauceType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
