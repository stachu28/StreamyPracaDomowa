package homework.model;

public enum AccountCategory {
    CURRENT("Rachunki bieżące"),
    SAVINGS("Rachunki oszczędnościowe"),
    DEPOSIT("Lokaty");

    private final String name;

    AccountCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
