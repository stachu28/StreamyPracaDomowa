package homework.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
    private final AccountType type;
    private final String number;
    private final BigDecimal amount;
    private final Currency currency;
    private final LocalDate openedAt;

    public Account(AccountType type, String number, BigDecimal amount, Currency currency, LocalDate openedAt) {
        this.type = type;
        this.number = number;
        this.amount = amount;
        this.currency = currency;
        this.openedAt = openedAt;
    }

    public AccountType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDate getOpenedAt() {
        return openedAt;
    }

    @Override
    public String toString() {
        return number + " [" + type + "] " + amount + " " + currency + ", otwarte " + openedAt;
    }

}
