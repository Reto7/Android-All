package ch.ibw.reto.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    }
}
