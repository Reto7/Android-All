package com.example.user.currencycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        Am Schluss eine Übung begonnen (Hausaufgabe)
        Neues Projekt: CurrencyCalculator
        Immer fix von CHF ausgehend
        1. Eingabefeld (entweder eine Dropdownliste oder Freitext):
        Zielwährung (USD,EUR,GBP)
        Falls Freitext dann mit Exceptionhandling (falls man eine falsche Wgh. eingibt)
        2. Eingabefeld
        den umzurechnenden Betrag
        3. Button und Ausgabefeld, z.B. "10 CHF sind umgerechnet 12839.- USD"
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
