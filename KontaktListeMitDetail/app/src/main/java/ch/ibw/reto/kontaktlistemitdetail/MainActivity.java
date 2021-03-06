package ch.ibw.reto.kontaktlistemitdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____Kontaktliste:Main";

    private EditText editEintrag;
    private ListView listViewToDoListe;

    private ArrayList<Kontakt> dieListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dieListe = new ArrayList<Kontakt>();
        dieListe.add(new Kontakt("Hans Muster", "+41786643120","http://www.ibw.ch"));
        dieListe.add(new Kontakt("Susi Muster", "+41786643120","http://www.20min.ch"));
        dieListe.add(new Kontakt("Alice im Wunderland", "+41786643120","http://www.blick.ch"));
        dieListe.add(new Kontakt("Jack Sparrow", "+41786643120","http://www.nasa.gov"));


        listViewToDoListe = (ListView) findViewById(R.id.liste);

        // der ListView das ListenObjekt generell zuteilen
        final ArrayAdapter<Kontakt> adapter = new ArrayAdapter<Kontakt>(MainActivity.this,
                R.layout.reto_listitem, dieListe);   //R.layout.reto_listitem  oder  android.R.layout.simple_list_item_1
        listViewToDoListe.setAdapter(adapter);

        // SHORT KLICK
        listViewToDoListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(PROG, "Position: " +position);
                Log.i(PROG, "Id: " +id);
                Log.i(PROG, "Kontakt: " +dieListe.get(position));
                // CALL DETAIL ACTIVITY
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("KONTAKT", dieListe.get(position) );
                startActivity(intent);
                /*
                Rueckgabewerte der anderen Activity bekommen:
                    startActivotyForResult()
                    onActivityResult()
                 */

            }
        });

        // LONG KLICK
        listViewToDoListe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(PROG, "Position: " +position);
                Log.i(PROG, "Id: " +id);
                Log.i(PROG, "Kontakt: " +dieListe.get(position));
                // CALL DETAIL ACTIVITY
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("KONTAKT", dieListe.get(position) );
                startActivity(intent);
                return true;
            }
        });

    }
}
