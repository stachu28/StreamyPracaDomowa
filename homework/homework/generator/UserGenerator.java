package homework.generator;

import homework.model.Account;
import homework.model.Permit;
import homework.model.Sex;
import homework.model.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UserGenerator {
    public List<User> generate() {
        List<Account> accounts = new AccountGenerator().generate();
        List<User> result = new LinkedList<>();

        result.add(new User("Adam", "Wojcik", "adam.wojcik@fanta.com", Sex.MAN, 17,
                "mateusz.kowalski@fanta.com",
                Arrays.asList(accounts.get(0), accounts.get(1)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER))
        );

        result.add(new User("Mateusz", "Kowalski", "mateusz.kowalski@fanta.com", Sex.MAN, 33,
                "jan.bazuka@sprite.com",
                List.of(accounts.get(2)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN)
        ));

        result.add(new User("Bartek", "Pasibrzuch", "bartek.pasibrzuch@fanta.com", Sex.OTHER, 18,
                "mateusz.kowalski@fanta.com",
                List.of(accounts.get(3)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Jan", "Bazuka", "jan.bazuka@sprite.com", Sex.MAN, 46,
                "zosia.psikuta@sprite.com",
                Arrays.asList(accounts.get(4), accounts.get(5), accounts.get(6)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN)
        ));

        result.add(new User("Zosia", "Psikuta", "zosia.psikuta@sprite.com", Sex.WOMAN, 67,
                null,
                Arrays.asList(accounts.get(7), accounts.get(8), accounts.get(9)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Magdalena", "Warszawska", "magdalena.warszawska@nescafe.com", Sex.WOMAN, 33,
                "filip.flirciczart@nescafe.com",
                Arrays.asList(accounts.get(10), accounts.get(11)),
                Arrays.asList(Permit.DEPOSIT, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Amadeusz", "Mocarz", "amadeusz.mocarz@nescafe.com", Sex.MAN, 29,
                "magdalena.warszawska@nescafe.com",
                Arrays.asList(accounts.get(12)),
                Arrays.asList(Permit.ORDER_HISTORY)
        ));

        result.add(new User("Filip", "Flirciczart", "filip.flirciczart@nescafe.com", Sex.MAN, 33,
                "jan.bazuka@sprite.com",
                Arrays.asList(accounts.get(13)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Zenek", "Biednapalka", "zenek.biednapalka@nescafe.com", Sex.MAN, 18,
                "zenon.kucowski@gerber.com",
                Arrays.asList(),
                Arrays.asList()
        ));

        result.add(new User("Zenon", "Kucowski", "zenon.kucowski@gerber.com", Sex.OTHER, 21,
                "zenek.biednapalka@nescafe.com",
                Arrays.asList(),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Mariusz", "Dreh", "mariusz.dreh@nestle-group.com", Sex.OTHER, 50,
                "marcin.marcinowicz@gerber.com",
                Arrays.asList(accounts.get(14)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Marcin", "Marcinowicz", "marcin.marcinowicz@gerber.com", Sex.MAN, 37,
                "karol.romanowicz@pepsi.com",
                Arrays.asList(
                        accounts.get(15),
                        accounts.get(16),
                        accounts.get(17),
                        accounts.get(18),
                        accounts.get(19),
                        accounts.get(20)
                ),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Jan", "Nowicki", "jan.nowicki@nestea.com", Sex.MAN, 45,
                "zosia.psikuta@sprite.com",
                Arrays.asList(accounts.get(22)),
                Arrays.asList(Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Kasia", "Nawalka", "kasia.nawalka@lays.com", Sex.WOMAN, 29,
                "martin.prawicowy@lays.com",
                Arrays.asList(accounts.get(23), accounts.get(24)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN)
        ));

        result.add(new User("Martin", "Prawicowy", "martin.prawicowy@lays.com", Sex.MAN, 29,
                "jan.nowicki@nestea.com",
                Arrays.asList(accounts.get(25), accounts.get(26)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Karol", "Romanowicz", "karol.romanowicz@pepsi.com", Sex.MAN, 64,
                "ceo@holding.com",
                Arrays.asList(accounts.get(27), accounts.get(28)),
                Arrays.asList(Permit.LOAN)
        ));

        result.add(new User("Marta", "Wialkibuz", "marta.wialkibuz@mirinda.com", Sex.WOMAN, 33,
                "karol.romanowicz@pepsi.com",
                Arrays.asList(accounts.get(29)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Patryk", "Piwny", "patryk.piwny@pepsi.com", Sex.MAN, 28,
                "karol.romanowicz@pepsi.com",
                Arrays.asList(accounts.get(30)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        result.add(new User("Zenek", "Jawowy", "zenek.jawowy@mirinda.com", Sex.MAN, 22,
                "alfred.pasibrzuch@mirinda.com",
                Arrays.asList(accounts.get(31)),
                Arrays.asList()
        ));

        result.add(new User("Alfred", "Pasibrzuch", "alfred.pasibrzuch@mirinda.com", Sex.MAN, 40,
                null,
                Arrays.asList(accounts.get(32), accounts.get(33), accounts.get(34)),
                Arrays.asList(Permit.DEPOSIT, Permit.TRANSFER, Permit.LOAN, Permit.ORDER_HISTORY)
        ));

        return result;
    }
}
