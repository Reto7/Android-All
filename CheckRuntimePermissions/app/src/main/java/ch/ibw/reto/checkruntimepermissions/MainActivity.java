package ch.ibw.reto.checkruntimepermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____CheckPermissions";


    private EditText editTextFeld;
    private Spinner spinnerZielwaehrung;
    private TextView textAusgabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the values from input field
        editTextFeld = (EditText) findViewById(R.id.edit_feld);
        //spinnerZielwaehrung = (Spinner) findViewById(R.id.spinner_zielwaehrung);

        // Ausgabefeld
        textAusgabe = (TextView) findViewById(R.id.label_ausgabe);

//        // spinner dropdownliste mit werten befuellen (aus String Enumeration)
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_spinner_item, String.values());
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerZielwaehrung.setAdapter(adapter);

        // get the button
        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diePermission = (editTextFeld.getText().toString());
                Log.w(PROG, "Permission: " + diePermission);
                if (diePermission.length() > 0) {
                    //String zielWaehrung = spinnerZielwaehrung.getSelectedItem().toString();
                    //Log.w(PROG, "Ziehlwaehrung: " + zielWaehrung);

                    // PERMISSION CHECK!
//                    int permissionCheck = ContextCompat.checkSelfPermission(this,
//                            Manifest.permission.WRITE_CALENDAR);

                    int permissionCheck = checkSelfPermission(Manifest.permission.READ_CONTACTS);
                    String resulat;
                    if (permissionCheck==PackageManager.PERMISSION_GRANTED) {
                        resulat = "GRANTED";
                    } else {
                        resulat = "DENIED";
                    }
                    textAusgabe.setText("WRITE_CALENDAR:" + resulat);
                } else {
                    Toast.makeText(getApplicationContext(), "Bitte zuerst eine zu prüfende Permission eingeben", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
