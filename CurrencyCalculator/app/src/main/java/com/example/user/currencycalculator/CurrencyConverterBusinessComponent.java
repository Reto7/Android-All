package com.example.user.currencycalculator;

import android.util.Log;

/**
 * Created by user on 23.04.2017.
 */

public class CurrencyConverterBusinessComponent {

    public static String calculateChfToTargetCurrency(Currency targetCurrency, Double betrag) {
        Double resultat = betrag * targetCurrency.getExchangeRateChfToCurrency();
        Log.i(MainActivity.PROG,"Resultat: " +resultat.toString());
        return betrag +" CHF sind umgerechnet "+String.format("%.2f", resultat) +" " +targetCurrency;

    }

    public static String calculateChfToTargetCurrency(String targetCurrency, Double betrag) {
        return calculateChfToTargetCurrency(Currency.valueOf(targetCurrency) ,  betrag);
    }


}
