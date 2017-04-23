package com.example.user.currencycalculator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.user.currencycalculator.Currency.USD;

public class MainActivity extends AppCompatActivity {

    private String prog = "____CurrencyCalculator";
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

    private EditText editBetrag;
    private Spinner spinnerZielwaehrung;
    private TextView textAusgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the values from input field
        editBetrag = (EditText) findViewById(R.id.edit_betrag);
        spinnerZielwaehrung = (Spinner) findViewById(R.id.spinner_zielwaehrung);
        // Ausgabefeld
        textAusgabe = (TextView) findViewById(R.id.label_ausgabe);

        // spinner dropdownliste mit werten befuellen (aus Currency Enumeration)
        ArrayAdapter<Currency>adapter = new ArrayAdapter<Currency>(MainActivity.this,
                android.R.layout.simple_spinner_item, Currency.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerZielwaehrung.setAdapter(adapter);

        // get the button
        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double betrag = Double.parseDouble((editBetrag.getText().toString()));
                Log.w(prog,"Betrag: " +betrag);
                String zielWaehrung = spinnerZielwaehrung.getSelectedItem().toString();
                Log.w(prog,"Ziehlwaehrung: " +zielWaehrung);
                // Lookup Enum ab String z.B. "USD": Currency.valueOf(zielWaehrung);
                String ausgabe = CurrencyConverterBusinessComponent.calculateChfToTargetCurrency(zielWaehrung,betrag);
                textAusgabe.setText(ausgabe);
            }
        });





    }
}
