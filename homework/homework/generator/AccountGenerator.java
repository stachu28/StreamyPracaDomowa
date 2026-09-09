package homework.generator;

import homework.model.Account;
import homework.model.AccountType;
import homework.model.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AccountGenerator {
    public List<Account> generate() {
        return Arrays.asList(
                new Account(AccountType.LO1, "6754", new BigDecimal("10.50"), Currency.PLN, LocalDate.of(2019, 3, 14)),
                new Account(AccountType.ROR1, "1178", new BigDecimal("999.50"), Currency.USD, LocalDate.of(2020, 6, 19)),
                new Account(AccountType.ROR1, "8967", new BigDecimal("1000"), Currency.EUR, LocalDate.of(2021, 1, 11)),
                new Account(AccountType.ROR1, "112221", new BigDecimal("1667.22"), Currency.PLN, LocalDate.of(2018, 9, 8)),
                new Account(AccountType.ROR1, "1234", new BigDecimal("1888822.1"), Currency.EUR, LocalDate.of(2016, 5, 10)),
                new Account(AccountType.ROR1, "2346", new BigDecimal("8236626.12"), Currency.PLN, LocalDate.of(2015, 11, 27)),
                new Account(AccountType.ROR1, "7676", new BigDecimal("1230.00"), Currency.EUR, LocalDate.of(2021, 1, 11)),
                new Account(AccountType.ROR1, "0192", new BigDecimal("88890.00"), Currency.PLN, LocalDate.of(2022, 2, 18)),
                new Account(AccountType.ROR1, "8474", new BigDecimal("10000.60"), Currency.CHF, LocalDate.of(2024, 2, 29)),
                new Account(AccountType.RO1, "3892", new BigDecimal("70998.8"), Currency.EUR, LocalDate.of(2017, 7, 19)),
                new Account(AccountType.ROR1, "65423", new BigDecimal("800.99"), Currency.PLN, LocalDate.of(2022, 2, 18)),
                new Account(AccountType.RO2, "87631", new BigDecimal("100"), Currency.CHF, LocalDate.of(2023, 4, 1)),
                new Account(AccountType.LO1, "1235478", new BigDecimal("1"), Currency.PLN, LocalDate.of(2020, 12, 31)),
                new Account(AccountType.RO1, "72446", new BigDecimal("0.01"), Currency.CHF, LocalDate.of(2019, 8, 7)),
                new Account(AccountType.RO1, "90753", new BigDecimal("0"), Currency.CHF, LocalDate.of(2019, 8, 7)),
                new Account(AccountType.RO2, "865423", new BigDecimal("0"), Currency.CHF, LocalDate.of(2025, 1, 2)),
                new Account(AccountType.LO2, "9612541", new BigDecimal("23500.86"), Currency.USD, LocalDate.of(2018, 3, 21)),
                new Account(AccountType.RO1, "971561", new BigDecimal("9999"), Currency.USD, LocalDate.of(2023, 11, 7)),
                new Account(AccountType.LO2, "97156221", new BigDecimal("10.00"), Currency.CHF, LocalDate.of(2024, 6, 30)),
                new Account(AccountType.RO1, "867151", new BigDecimal("109823.00"), Currency.PLN, LocalDate.of(2016, 10, 4)),
                new Account(AccountType.RO1, "862252", new BigDecimal("123771"), Currency.CHF, LocalDate.of(2021, 9, 17)),
                new Account(AccountType.LO1, "872562", new BigDecimal("7332"), Currency.PLN, LocalDate.of(2015, 4, 18)),
                new Account(AccountType.RO2, "34563", new BigDecimal("2346"), Currency.PLN, LocalDate.of(2022, 7, 16)),
                new Account(AccountType.RO2, "1122", new BigDecimal("100"), Currency.USD, LocalDate.of(2020, 2, 19)),
                new Account(AccountType.RO1, "62222", new BigDecimal("1009"), Currency.PLN, LocalDate.of(2024, 9, 5)),
                new Account(AccountType.RO2, "73344", new BigDecimal("0"), Currency.PLN, LocalDate.of(2023, 3, 8)),
                new Account(AccountType.LO1, "8723212", new BigDecimal("2435"), Currency.USD, LocalDate.of(2017, 2, 1)),
                new Account(AccountType.RO2, "3457117", new BigDecimal("10000984"), Currency.PLN, LocalDate.of(2025, 5, 22)),
                new Account(AccountType.ROR2, "45218", new BigDecimal("108987.0"), Currency.CHF, LocalDate.of(2019, 11, 29)),
                new Account(AccountType.LO1, "24578", new BigDecimal("13873"), Currency.CHF, LocalDate.of(2021, 6, 12)),
                new Account(AccountType.LO1, "0000064", new BigDecimal("9766"), Currency.USD, LocalDate.of(2018, 12, 14)),
                new Account(AccountType.ROR2, "2322255", new BigDecimal("1000"), Currency.CHF, LocalDate.of(2024, 2, 29)),
                new Account(AccountType.ROR2, "666622", new BigDecimal("287"), Currency.CHF, LocalDate.of(2022, 10, 26)),
                new Account(AccountType.ROR2, "998292", new BigDecimal("1467"), Currency.CHF, LocalDate.of(2020, 8, 19)),
                new Account(AccountType.LO1, "938383", new BigDecimal("1600"), Currency.EUR, LocalDate.of(2016, 3, 15)),
                new Account(AccountType.LO1, "2018543", new BigDecimal("23000.86"), Currency.PLN, LocalDate.of(2023, 9, 27))
        );
    }
}
