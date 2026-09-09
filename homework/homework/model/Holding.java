package homework.model;

import java.util.List;

public class Holding {
    private final String name;
    private final Country country;
    private final List<Company> companies;

    public Holding(String name, Country country, List<Company> companies) {
        this.name = name;
        this.country = country;
        this.companies = companies;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public String toString() {
        return name + " (" + country + "), firm: " + companies.size();
    }
}
