package ch.ibw.reto.kontaktlistemitdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String PROG = "____Kontaktliste:Detail";

    private TextView anzeigefeld_kontaktname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Parameter auslesen
        Bundle extras = getIntent().getExtras();
        Kontakt kontakt = (Kontakt) extras.getSerializable("KONTAKT");

        Log.i(PROG, "Kontakt: " +kontakt);

        // get the fields
        anzeigefeld_kontaktname = (TextView) findViewById(R.id.anzeigefeld_kontaktname);
        anzeigefeld_kontaktname.setText(kontakt.getName());


    }
}
