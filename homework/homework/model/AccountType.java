package homework.model;

import java.math.BigDecimal;

public enum AccountType {
    ROR1("Rachunek bieżący", AccountCategory.CURRENT, "0.00"),
    ROR2("Internetowy hit", AccountCategory.CURRENT, "0.50"),
    RO1("Super zysk", AccountCategory.SAVINGS, "2.75"),
    RO2("Szybki zysk", AccountCategory.SAVINGS, "3.10"),
    LO1("Stabilna lokata", AccountCategory.DEPOSIT, "5.25"),
    LO2("Mocny procent", AccountCategory.DEPOSIT, "6.00");

    private final String name;
    private final AccountCategory category;

    /**
     * Oprocentowanie w procentach w skali roku, np. 5.25 oznacza 5,25%.
     */
    private final BigDecimal interestRate;

    AccountType(final String name, final AccountCategory category, final String interestRate) {
        this.name = name;
        this.category = category;
        this.interestRate = new BigDecimal(interestRate);
    }

    public String getName() {
        return name;
    }

    public AccountCategory getCategory() {
        return category;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
