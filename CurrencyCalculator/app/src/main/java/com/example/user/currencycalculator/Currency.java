package com.example.user.currencycalculator;

import java.util.HashMap;

/**
 * Created by user on 23.04.2017.
 */

public enum Currency {
    USD, EUR, GBP, INR;

    public Double getExchangeRateChfToCurrency(){
        // CHF 1    USD 1.004
        // CHF 1    EUR 0.936
        // CHF 1    GBP 0.783
        // CHF 1    INR 648870
        //
        HashMap<Currency, Double> hm = new HashMap<Currency, Double>();
        hm.put(Currency.USD, new Double(1.004));
        hm.put(Currency.EUR, new Double(0.936));
        hm.put(Currency.GBP, new Double(0.783));
        hm.put(Currency.INR, new Double(648870));
        return hm.get(this).doubleValue();
    }
}
