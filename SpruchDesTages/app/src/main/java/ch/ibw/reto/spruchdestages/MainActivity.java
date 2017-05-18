package ch.ibw.reto.spruchdestages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewWelcome;
    private TextView textViewSpruch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ausgabefeld
        textViewWelcome = (TextView) findViewById(R.id.label_welcome);
        textViewSpruch = (TextView) findViewById(R.id.label_spruch);

        Person person = new Person();

        // auslesen
        SharedPreferences prefs = getSharedPreferences("Special Prefs", Activity.MODE_PRIVATE);
        String name = prefs.getString("name",null);
        Log.w("X", "Name ausgelesen (1): " + name);
        if (name != null) {
            person.setName(name);
        }

        Log.w("X", "Person: " + person.getName());
        if (person.getName() != null) {

            // Falls User bekannt (abgespeichert, dann nur Spruch)
            Log.w("X", "Person ist bekannt ");

        }
        else {
            // Falls User unbekannt, die NamensErfassung starten, dann den Namen abspeichern
            Log.w("X", "Person ist unbekannt ");

            // CALL DETAIL ACTIVITY
            Intent intent = new Intent(getApplicationContext(), NamensErfassungActivity.class);
            //intent.putExtra("KONTAKT", dieListe.get(position) );
            startActivity(intent);
            /*
            TODO besser mit Rueckgabewert loesen und hier abspeichern
            Rueckgabewerte der anderen Activity bekommen:
                startActivotyForResult()
                onActivityResult()
            */


            // nochmals auslesen
            prefs = getSharedPreferences("Special Prefs", Activity.MODE_PRIVATE);
            name = prefs.getString("name",null);
            Log.w("X", "Name ausgelesen (2): " + name);
            if (name != null) {
                person.setName(name);
            }

        }

        textViewSpruch.setText("Heute ist der schönste Donnerstag des Jahres");
        textViewWelcome.setText("Hallo "+person.getName());

    }
}
