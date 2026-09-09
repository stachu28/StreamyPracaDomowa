package homework.model;

public enum Region {
    EUROPE("Europa"),
    NORTH_AMERICA("Ameryka Północna");

    private final String name;

    Region(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
