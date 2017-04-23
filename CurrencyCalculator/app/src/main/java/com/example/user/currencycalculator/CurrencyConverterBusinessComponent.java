package com.example.user.currencycalculator;

/**
 * Created by user on 23.04.2017.
 */

public class CurrencyConverterBusinessComponent {

    public static Double fxChfToTarget(Currency targetCurrency, Double betrag) {
        // CHF 1    USD 1.004
        // CHF 1    EUR 0.936
        // CHF 1    GBP 0.783
        // CHF 1    INR 648870
        switch (targetCurrency) {
            case USD: return betrag * 1.004;
            case EUR: return betrag * 0.936;
            case GBP: return betrag * 0.783;
            case INR: return betrag * 648870;
        }
        return null;
    }

    public static String calculateChfToTargetCurrency(Currency targetCurrency, Double betrag) {
        return betrag +" CHF sind umgerechnet "+fxChfToTarget(targetCurrency,betrag) +" " +targetCurrency;
    }

    public static String calculateChfToTargetCurrency(String targetCurrency, Double betrag) {
        return calculateChfToTargetCurrency(Currency.valueOf(targetCurrency) ,  betrag);
    }


}
