package homework.model;

import java.util.List;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Sex sex;
    private final int age;

    /**
     * E-mail przełożonego. Wartość {@code null} oznacza, że pracownik nie ma przełożonego.
     * Uwaga: w danych są celowo zaszyte pułapki – e-mail przełożonego, którego nie ma w danych,
     * oraz dwie osoby, które są przełożonymi nawzajem dla siebie (cykl).
     */
    private final String managerEmail;

    private final List<Account> accounts;
    private final List<Permit> permits;

    public User(String firstName, String lastName, String email, Sex sex, int age, String managerEmail,
                List<Account> accounts, List<Permit> permits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.managerEmail = managerEmail;
        this.accounts = accounts;
        this.permits = permits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Permit> getPermits() {
        return permits;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ", " + sex + ", " + email + ")";
    }
}
