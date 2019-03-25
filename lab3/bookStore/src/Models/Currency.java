package Models;

import java.util.HashMap;

public class Currency {
    public static final String USD = "USD";
    public static final String PLN = "PLN";
    public static final String EUR = "EUR";
    public static final String ALL = "All";

    public static Double getPriceInPLN(Book book) {
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put(Currency.EUR, 4.29275362);
        exchangeRates.put(Currency.USD, 3.79207305);
        exchangeRates.put(Currency.PLN, 1.0);

        String bookCurrency = book.getCurrency();
        Double rate = exchangeRates.get(bookCurrency);
        Double price = book.getPrice();
        return price * rate;
    }
}
