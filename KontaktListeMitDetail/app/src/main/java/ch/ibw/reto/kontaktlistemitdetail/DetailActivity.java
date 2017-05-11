package ch.ibw.reto.kontaktlistemitdetail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

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
        final Kontakt kontakt = (Kontakt) extras.getSerializable("KONTAKT");

        Log.i(PROG, "Kontakt: " +kontakt);

        // set the fields
        anzeigefeld_kontaktname = (TextView) findViewById(R.id.anzeigefeld_kontaktname);
        anzeigefeld_kontaktname.setText(kontakt.getName());
        //
        anzeigefeld_kontakttel = (TextView) findViewById(R.id.anzeigefeld_kontakttel);
        anzeigefeld_kontakttel.setText(kontakt.getTelefonnummer());
        //
        anzeigefeld_kontaktweb = (TextView) findViewById(R.id.anzeigefeld_kontaktweb);
        anzeigefeld_kontaktweb.setText(kontakt.getWebseite());


        // KLICK
        anzeigefeld_kontakttel.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Log.i(PROG, "Tel geklickt ...");
                   Intent intent1 = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+kontakt.getTelefonnummer() ));
                   startActivity(intent1);
               }
           }
        );

        // KLICK
        anzeigefeld_kontaktweb.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Log.i(PROG, "Web geklickt ...");
                  Intent intent2 = new Intent(Intent.ACTION_VIEW,
                          Uri.parse(kontakt.getWebseite() ));
                  startActivity(intent2);
              }
          }
        );




    }
}
