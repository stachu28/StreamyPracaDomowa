package homework.generator;

import homework.model.Company;
import homework.model.Country;
import homework.model.User;

import java.util.Arrays;
import java.util.List;

public class CompanyGenerator {
    public List<Company> generate() {
        UserGenerator userGenerator = new UserGenerator();
        List<User> users = userGenerator.generate();

        return Arrays.asList(
                new Company("Fanta", Country.PL, "Warszawa", 1998,
                        Arrays.asList(
                                users.get(0),
                                users.get(1),
                                users.get(2)
                        )),
                new Company("Sprite", Country.DE, "Berlin", 2005,
                        Arrays.asList(
                                users.get(3),
                                users.get(4)
                        )),
                new Company("Nescafe", Country.CH, "Zurych", 1985,
                        Arrays.asList(
                                users.get(5),
                                users.get(6),
                                users.get(7),
                                users.get(8)
                        )),
                new Company("Gerber", Country.US, "Nowy Jork", 1972,
                        Arrays.asList(
                                users.get(9),
                                users.get(10),
                                users.get(11)
                        )),
                new Company("Nestea", Country.PL, "Kraków", 2015,
                        Arrays.asList(
                                users.get(12)
                        )),
                new Company("Lays", Country.GB, "Londyn", 1990,
                        Arrays.asList(
                                users.get(13),
                                users.get(14)
                        )),
                new Company("Pepsi", Country.US, "Chicago", 1965,
                        Arrays.asList(
                                users.get(15),
                                users.get(16),
                                users.get(17)
                        )),
                new Company("Mirinda", Country.FR, "Lyon", 2001,
                        Arrays.asList(
                                users.get(18),
                                users.get(19)
                        )
                ));
    }
}
