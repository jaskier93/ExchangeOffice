package exchangeofficeapp;


public enum Currency {
    PLN("PLN"),
    EUR("EUR"),
    USD("USD"),
    GBP("GBP"),
    CZK("CZK"),
    RUB("RUB"),
    JPY("JPY");
    private String name;

    public String getName() {
        return name;
    }
    Currency(String name) {
        this.name = name;
    }
}
