package exchangeofficeapp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class ExchangeOffice {

    private Map<Currency, BigDecimal> wallet = new HashMap<>();
    private BigDecimal initialFounds = new BigDecimal("10000");
    private double exchangeMargin = 0.2;

    public ExchangeOffice() {
        for (Currency currency : Currency.values()) {
            wallet.put(currency, initialFounds);
        }
    }

    private String getValue(BigDecimal bigDecimal) {
        return bigDecimal.round(new MathContext(7, RoundingMode.HALF_UP)).toString();
    }

    public void showFunds() {
        System.out.print("Current founds: \n");

        for (Currency name : wallet.keySet()) {
            String key = name.toString();
            String value = getValue(wallet.get(name));
            System.out.print(value + " " + key + " \n");
        }
        System.out.println("\n");
    }

    public void exchange(double amount, Currency from, Currency to) {

        BigDecimal toAdd = new BigDecimal(amount * (1.0- exchangeMargin)).multiply(BigDecimal.valueOf(Converter.convert(from, to)));
        BigDecimal toTake = new BigDecimal(amount * (-1.0));

        if (checkIfEnoughFounds(amount, from)) {
            System.out.println("Exchanging " + amount + " " + from.getName() + " to " + getValue(toAdd) + " " + to.getName());
            wallet.put(to, wallet.get(to).add(toAdd));
            wallet.put(from, wallet.get(from).add(toTake));
        } else {
            System.out.println("Cannot exchange " + amount + " " + from.getName() + " to " + getValue(toAdd) + " " + to.getName() + " : insufficient funds.");
        }
        showFunds();
    }

    private boolean checkIfEnoughFounds(double amount, Currency from) {
            return  wallet.get(from).compareTo(BigDecimal.valueOf(amount)) >= 0;
    }
    
    
}