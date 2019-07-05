package exchangeofficeapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeofficeappApplication {

    public static void main(String[] args) {
        ExchangeOffice wallet = new ExchangeOffice();

        wallet.exchange(800.0, Currency.PLN, Currency.EUR);
        wallet.exchange(450.0, Currency.GBP, Currency.RUB);
        wallet.exchange(350.0, Currency.JPY, Currency.USD);
        wallet.exchange(290.0, Currency.USD, Currency.CZK);
        wallet.exchange(170.0, Currency.EUR, Currency.PLN);
        wallet.exchange(670.0, Currency.RUB, Currency.GBP);
        wallet.exchange(340.0, Currency.CZK, Currency.JPY);
    }
}


