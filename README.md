# 🏠 Zadanie domowe – Streamy

Praca domowa do lekcji [`21_strimy.md`](../../kurs_zajecia/21_strimy.md). Pracujesz na jednym pliku
`homework/homework/Exercises.java` – uzupełniasz kolejne metody, uruchamiasz `main` i porównujesz wynik
z plikiem [`oczekiwane-wyniki.txt`](oczekiwane-wyniki.txt).

Zadania są podzielone na cztery części o rosnącej trudności:

| Część | Trudność | Ile zadań | O czym |
|---|---|---|---|
| A | ★ | 20 | rozgrzewka: `filter`, `map`, `count`, `collect`, `flatMap`, `Optional` |
| B | ★★ | 19 | `Collectors`: grupowanie, partycjonowanie, statystyki, `teeing` |
| C | ★★★ | 19 | rekordy jako klucze, własny kolektor, `Stream.iterate`, `takeWhile`, `mapMulti`, `parallel` |
| D | ★★ | 6 | naprawa zepsutego kodu – klasyczne pułapki streamów |

Rób je po kolei. Część C w kilku miejscach korzysta z metod pomocniczych napisanych w części A
(`getAccountAmountInPLN`, `getUserAmountInPLN`, `getUserStream`, `getAccoutStream`) – bez nich nie ruszysz.

---

## Jak uruchomić

Projekt jest bez Mavena, odpalasz go z katalogu `homework`:

```bash
cd homework
javac -encoding UTF-8 -d out $(find . -name "*.java")
java -Dfile.encoding=UTF-8 -cp out homework.Exercises
```

Albo po prostu odpal metodę `main` z IntelliJ. Wymagana Java 17+ – używamy rekordów oraz `mapMulti`
(zadanie C19), a jedno i drugie jest dostępne od Javy 16.

Raport wypisuje po kolei wszystkie zadania. Metody, których jeszcze nie zrobiłeś, pokazują
`(brak wyniku - zadanie do zrobienia)`, a te, które wybuchają – nazwę wyjątku. Nie musisz nic
zmieniać w sekcji `RAPORT` (jedyny wyjątek to jedna zakomentowana linia w zadaniu D3).

---

## Zasady

1. **Żadnych pętli** `for` / `while` w zadaniach A, B i C. Cała robota w strumieniu.
2. **Żadnych list, do których dopisujesz w trakcie działania strumienia.** Wyjątki są dokładnie dwa
   i są wprost opisane w treści zadań (C4 – saldo narastające, C16 – dowód leniwości).
3. **Nie zmieniaj modelu ani generatorów.** Jeśli czegoś brakuje, to znaczy, że da się to wyliczyć.
4. **`peek` tylko do debugowania** – jedyne miejsce, gdzie jest częścią rozwiązania, to C16.
5. Kwoty w PLN zaokrąglasz **na samym końcu** obliczeń: `setScale(2, RoundingMode.HALF_UP)`.
6. Kolejność w mapie ma znaczenie tylko tam, gdzie treść zadania tego wymaga (`LinkedHashMap`,
   `TreeMap`, kolejność enuma) – wtedy zwróć odpowiednią implementację mapy, a nie zwykły `HashMap`.

---

## Dane, na których pracujesz

Struktura: **3 holdingi → 8 firm → 20 pracowników → 34 rachunki**
(generator tworzy 36 rachunków, dwa z nich nie należą do nikogo – nie zobaczysz ich w strumieniu).

Model został rozszerzony względem poprzedniej wersji:

| Klasa / enum | Nowe pola |
|---|---|
| `Holding` | `country` |
| `Company` | `country`, `city`, `foundedYear` |
| `User` | `email`, `managerEmail` (może być `null`) |
| `Account` | `openedAt` |
| `AccountType` | `category` (`AccountCategory`), `interestRate` – procent w skali roku |
| `Country` (nowy) | `name`, `region` (`Region`) |
| `Region` (nowy) | `EUROPE`, `NORTH_AMERICA` |
| `AccountCategory` (nowy) | `CURRENT`, `SAVINGS`, `DEPOSIT` |

### Pułapki zaszyte w danych celowo

Nie są błędem – kilka zadań istnieje właśnie po to, żebyś je znalazł:

* **cykl w hierarchii** – Zenek Biednapalka i Zenon Kucowski są przełożonymi nawzajem dla siebie
  (naiwna rekurencja albo `Stream.iterate` bez zabezpieczenia = zawieszony program),
* **wisząca referencja** – Karol Romanowicz ma przełożonego `ceo@holding.com`, którego nie ma w danych,
* **dwie osoby bez przełożonego** – Zosia Psikuta i Alfred Pasibrzuch (`managerEmail == null`),
* **dwie błędne domeny e-mail** – ktoś pracuje w innej firmie, niż wskazuje jego adres,
* **cztery pary rachunków** otwartych tego samego dnia i w tej samej walucie (jedna z nich w dniu 29.02.2024),
* **rachunki z saldem 0**, dwóch pracowników **bez żadnego rachunku**, dwóch **bez żadnego uprawnienia**,
* **powtarzające się imiona** (dwóch Janów, dwóch Zenków) – kolizja klucza w `toMap`.

---

## Konwencja przeliczania walut – przeczytaj, zanim policzysz cokolwiek

`Currency.getRate()` zwraca **`float`**. Jeśli zrobisz `BigDecimal.valueOf(account.getCurrency().getRate())`,
dostaniesz `4.230000019073486` i wszystkie sumy rozjadą ci się na dalszych miejscach po przecinku.

Oczekiwane wyniki policzono tak:

```java
account.getAmount()
        .multiply(new BigDecimal(String.valueOf(account.getCurrency().getRate())))
        .round(new MathContext(10, RoundingMode.HALF_UP));
```

czyli kurs przez `String.valueOf`, a wynik zaokrąglony do 10 cyfr znaczących
(temat opisany w podpowiedzi z zadania `getRichestWoman`: https://stackoverflow.com/a/55052733/9360524).

---

## Część A – podstawy (★)

Zadania takie jak dotychczas, bez zmian: `getHoldingsWhereAreCompanies`, `getHoldingNames`,
`getHoldingNamesAsString`, `getCompaniesAmount`, `getAllUserAmount`, `getAllCompaniesNamesAsLinkedList`,
`getAccountAmountInPLN`, `getUsersForPredicate`, `executeForEachCompany`, `getRichestWoman`,
`getFirstNCompany`, `getUserPerCompany`, `getUser`, `createAccountsMap`, `getUserNames`, `showAllUser`,
`getCurenciesSet` oraz trzy metody pomocnicze `getCompanyStream` / `getUserStream` / `getAccoutStream`.

> W `getHoldingNames` przyjmujemy interpretację „nazwa w całości wielkimi literami" (`NESTLE`, `COCA-COLA`,
> `PEPSICO`) – tak policzono oczekiwany wynik.

---

## Część B – Collectors (★★)

| Metoda | Co ćwiczysz | Sekcja lekcji |
|---|---|---|
| `getCompaniesCountPerCountry` | `groupingBy` + `counting` | 6.2, 6.5 |
| `getCompanyNamesPerRegionAndCountry` | `groupingBy` w `groupingBy` + `mapping` | 6.2 |
| `getTotalBalanceInPlnPerHolding` | 3 poziomy `flatMap` + `reducing` na `BigDecimal` | 4.8, 5.7 |
| `getAccountNumbersPerType` | `groupingBy` z `EnumMap` + `mapping` | 6.2 |
| `partitionUserNamesByAge` | `partitioningBy` z downstreamem | 6.3 |
| `getUsersCountPerCompanyDescending` | sortowanie po wartości → `LinkedHashMap` | 4.4, 6.1 |
| `getUserWithMostAccounts` | `max` + `Comparator.thenComparing` | 5.4 |
| `getAverageAgePerSex` | `averagingInt` | 6.5 |
| `getAgeStatistics` | `mapToInt` + `summaryStatistics` | 4.3, 5.9 |
| `getTotalBalancePerCurrency` | `groupingBy` + `reducing`, bez przeliczania | 6.2 |
| `getTopRichestUsers` | sortowanie po wyliczonej kwocie + `limit` + formatowanie | 4.4, 4.6 |
| `getUsersCountPerPermit` | `flatMap` po liście uprawnień | 4.8 |
| `getUserNamesPerCompanyAndSex` | mapa w mapie w mapie | 6.1, 6.2 |
| `getPermitsHistogram` | `joining` + `String.format` + `repeat` | 6.4 |
| `getAverageBalanceInPlnPerCategory` | **`teeing`** (suma i licznik naraz) | 6.7 |
| `getDuplicatedFirstNames` | grupowanie, potem filtrowanie wyników | 6.2 |
| `getRichestAccountPerCurrency` | `maxBy` jako downstream (zwraca `Optional`) | 6.5 |
| `getYearlyInterestInPlnPerCategory` | `collectingAndThen` + arytmetyka `BigDecimal` | 6.6 |
| `getUserNamesPerAgeBracket` | klucz wyliczany + `TreeMap` | 6.2 |

---

## Część C – wyższa szkoła jazdy (★★★)

Do dyspozycji masz trzy gotowe rekordy: `CompanyUser`, `AccountRow`, `DayCurrency`. Rekord jako klucz mapy
działa od razu – ma wygenerowane `equals` i `hashCode`.

| Metoda | Co ćwiczysz |
|---|---|
| `getCompanyUserStream` | `flatMap` z zachowaniem kontekstu (firma + pracownik) |
| `getCompanyNamesPerPermit` | pary `Map.entry` + `groupingBy` + `TreeSet` jako downstream |
| `getAccountRowStream` | czteropoziomowy `flatMap` – „płaski wiersz" danych |
| `getCumulativeBalanceInPlnByOpenDate` | saldo narastające; świadome użycie akumulatora i wiedza, czemu to nie zadziała w `parallel` |
| `getTotalBalanceInPlnPerOpeningYear` | `groupingBy` + `TreeMap` + `collectingAndThen` |
| `getAccountsCountPerOpeningWeekDay` | `EnumMap` po `DayOfWeek` |
| `getManagerChain` | `Stream.iterate` (Java 9) + `takeWhile` + ochrona przed cyklem |
| `getOrgDepthPerEmail` | użycie własnej metody w kolektorze |
| `getUserWithLongestManagerChain` | `max` po wyliczonej wartości |
| `findUsersWithMismatchedEmailDomain` | walidacja danych na parach firma-pracownik |
| `findUnknownManagerEmails` | porównanie dwóch zbiorów wyciągniętych z tego samego strumienia |
| `buildHoldingReport` | **`teeing`** + `joining` + `String.format` – raport tekstowy |
| `sumInPlnCollector` | **własny kolektor** przez `Collector.of` |
| `getTotalBalanceInPlnPerCity` | użycie własnego kolektora jako downstream + `mapping` |
| `findAccountsOpenedSameDayInSameCurrency` | rekord jako **klucz złożony** + filtrowanie grup |
| `countCheckedAccountsUntilFirstMatch` | dowód **leniwości** i short-circuitingu |
| `getCompanyNamesWhereAllUsersHaveAllPermits` | `allMatch` w zagnieżdżeniu + pułapka pustego strumienia |
| `getTotalBalanceInPlnParallel` | `parallel` bezpieczny vs. `parallel` z efektem ubocznym |
| `getCompanyNamesPerPermitWithMapMulti` | dla chętnych: `mapMulti` zamiast `flatMap` |

Trzy zadania z tej części wymagają **odpowiedzi w komentarzu**, nie tylko kodu:
`getCumulativeBalanceInPlnByOpenDate` (dlaczego akumulator psuje się w `parallel`),
`getCompanyNamesWhereAllUsersHaveAllPermits` (dlaczego `allMatch` na pustym strumieniu zwraca `true`),
`getTotalBalanceInPlnParallel` (dlaczego `reduce` jest bezpieczny, a `forEach` + `ArrayList` nie).

---

## Część D – pułapki (napraw kod)

Sześć metod napisanych źle. Dla każdej: **wyjaśnij w komentarzu, co jest nie tak**, i napraw kod tak,
żeby robił to, co obiecuje Javadoc.

| Metoda | Objaw | Sekcja lekcji |
|---|---|---|
| `pulapkaReuzycieStreamu` | `IllegalStateException: stream has already been operated upon or closed` | 7.1 |
| `pulapkaKolizjaWToMap` | `IllegalStateException: Duplicate key Jan` | 7.4 |
| `pulapkaNieskonczonyStream` | program się zawiesza (raport tego nie odpala – patrz Javadoc) | 7.2 |
| `pulapkaSideEffect` | wynik jest **pusty**, mimo że `map` „na pewno się wykonuje" | 7.7 |
| `pulapkaBoxing` | wynik poprawny, ale kod pakuje `int` w `Integer` na każdym elemencie | 7.6 |
| `pulapkaOptionalGet` | `NoSuchElementException: No value present` | 7.5 |

> `pulapkaSideEffect` to najciekawsza z nich. Zajrzyj do dokumentacji `Stream.count()` – od Javy 9
> potrafi nie wykonać pipeline'u w ogóle, jeśli umie policzyć elementy bez tego.

---