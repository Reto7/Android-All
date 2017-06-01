package ch.ibw.reto.studentdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____StudentDatabase";

    private EditText editStudent;
    private Spinner spinnerStudienrichtung;
    //  private TextView textAusgabe;
    private ListView listViewToDoListe;

    ArrayList<String> studentenListe;

    private DbAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        dbAdapter = new DbAdapter(getApplicationContext());
        dbAdapter.open();

        // get the values from input field
        editStudent = (EditText) findViewById(R.id.edit_student);
        spinnerStudienrichtung = (Spinner) findViewById(R.id.spinner_studienrichtung);
        listViewToDoListe = (ListView) findViewById(R.id.liste);

        // studienrichtung liste in spinner
        // spinner dropdownliste mit werten befuellen (aus Currency Enumeration)
        ArrayAdapter<Studienrichtung> adapter = new ArrayAdapter<Studienrichtung>(MainActivity.this,
                android.R.layout.simple_spinner_item, Studienrichtung.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStudienrichtung.setAdapter(adapter);

        //
        zeigeAlleStudenten();

        
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

                    Log.w(PROG, "DB Adapter!");
                    //dbAdapter.insertStudent(studentFeld);
                    dbAdapter.insertStudent(studentFeld,studienrichtung.getId());

                    //
                    zeigeAlleStudenten();

                } else {
                    Toast.makeText(getApplicationContext(), "Bitte zuerst einen Studenten eingeben", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void zeigeAlleStudenten() {
        studentenListe = dbAdapter.readAllStudents();
        //
        // der ListView das ListenObjekt generell zuteilen
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentenListe);   //R.layout.reto_listitem  oder  android.R.layout.simple_list_item_1
        listViewToDoListe.setAdapter(adapter2);
    }
}
