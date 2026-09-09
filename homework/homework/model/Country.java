package homework.model;

public enum Country {
    PL("Polska", Region.EUROPE),
    DE("Niemcy", Region.EUROPE),
    CH("Szwajcaria", Region.EUROPE),
    GB("Wielka Brytania", Region.EUROPE),
    FR("Francja", Region.EUROPE),
    US("Stany Zjednoczone", Region.NORTH_AMERICA);

    private final String name;
    private final Region region;

    Country(final String name, final Region region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }
}
