package homework.generator;

import homework.model.Company;
import homework.model.Country;
import homework.model.Holding;

import java.util.Arrays;
import java.util.List;

public class HoldingGenerator {
    public List<Holding> generate() {
        CompanyGenerator companyMockGenerator = new CompanyGenerator();
        List<Company> companies = companyMockGenerator.generate();
        return Arrays.asList(
                new Holding("Nestle", Country.CH, Arrays.asList(companies.get(2), companies.get(3), companies.get(4))),
                new Holding("Coca-Cola", Country.US, Arrays.asList(companies.get(0), companies.get(1))),
                new Holding("Pepsico", Country.US, Arrays.asList(companies.get(5), companies.get(6), companies.get(7)))
        );
    }
}
