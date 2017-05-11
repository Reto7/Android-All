package ch.ibw.reto.kontaktlistemitdetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String PROG = "____Kontaktliste:Detail";

    private TextView anzeigefeld_kontaktname;
    private TextView anzeigefeld_kontakttel;
    private TextView anzeigefeld_kontaktweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Parameter auslesen
        Bundle extras = getIntent().getExtras();
        Kontakt kontakt = (Kontakt) extras.getSerializable("KONTAKT");

        Log.i(PROG, "Kontakt: " +kontakt);

        // set the fields
        anzeigefeld_kontaktname = (TextView) findViewById(R.id.anzeigefeld_kontaktname);
        anzeigefeld_kontaktname.setText(kontakt.getName());
        //
        anzeigefeld_kontakttel = (TextView) findViewById(R.id.anzeigefeld_kontakttel);
        anzeigefeld_kontakttel.setText(kontakt.getName());
        //
        anzeigefeld_kontaktweb = (TextView) findViewById(R.id.anzeigefeld_kontaktweb);
        anzeigefeld_kontaktweb.setText(kontakt.getName());


    }
}
