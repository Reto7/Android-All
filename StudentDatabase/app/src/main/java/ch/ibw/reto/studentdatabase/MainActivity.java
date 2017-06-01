package ch.ibw.reto.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____StudentDatabase";

    private EditText editStudent;
    private Spinner spinnerStudienrichtung;
  //  private TextView textAusgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the values from input field
        editStudent = (EditText) findViewById(R.id.edit_student);
        spinnerStudienrichtung = (Spinner) findViewById(R.id.spinner_studienrichtung);

        // liste in spinner
        // spinner dropdownliste mit werten befuellen (aus Currency Enumeration)
        ArrayAdapter<Studienrichtung> adapter = new ArrayAdapter<Studienrichtung>(MainActivity.this,
                android.R.layout.simple_spinner_item, Studienrichtung.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudienrichtung.setAdapter(adapter);
        
        // BUTTON
        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String studentFeld = (editStudent.getText().toString());
                Log.w(PROG, "Student (Eingabefeld): " + studentFeld);
                if (studentFeld.length()>0) {
                    Studienrichtung studienrichtung = (Studienrichtung) spinnerStudienrichtung.getSelectedItem();
                    Log.w(PROG, "Studienrichtung: " + studienrichtung.toString());
                    Log.w(PROG, "Studienrichtung ID: " +studienrichtung.getId());
                    // Lookup Enum ab String z.B. "USD": Currency.valueOf(zielWaehrung);
                    //String ausgabe = CurrencyConverterBusinessComponent.calculateChfToTargetCurrency(zielWaehrung, betrag);
                    //textAusgabe.setText(ausgabe);
                } else {
                    Toast.makeText(getApplicationContext(), "Bitte zuerst einen Studenten eingeben", Toast.LENGTH_LONG).show();
                }
            }
        });
        
    }
}
