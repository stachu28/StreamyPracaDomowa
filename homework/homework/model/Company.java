package homework.model;

import java.util.List;

public class Company {
    private final String name;
    private final Country country;
    private final String city;
    private final int foundedYear;
    private final List<User> users;

    public Company(String name, Country country, String city, int foundedYear, List<User> users) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.foundedYear = foundedYear;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return name + " (" + city + ", " + country + ", " + foundedYear + "), pracownikow: " + users.size();
    }
}
