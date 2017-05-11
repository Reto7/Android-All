package ch.ibw.reto.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____ToDoList";

    private EditText editEintrag;
    private ListView listViewToDoListe;

    private ArrayList<String> dieListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dieListe = new ArrayList<String>();
        dieListe.add("Test 1");
        dieListe.add("Test 2");

        // get the values from input field
        editEintrag = (EditText) findViewById(R.id.edit_eintrag);
        listViewToDoListe = (ListView) findViewById(R.id.liste);

        // der ListView das ListenObjekt generell zuteilen
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, dieListe);
        listViewToDoListe.setAdapter(adapter);


        // fuer DELETE
        listViewToDoListe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(PROG, "Position: " +position);
                Log.i(PROG, "Id: " +id);
                dieListe.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        // get the button (fuer ADD)
        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (editEintrag.length()>0) {
                    Log.w(PROG, "Eintrag: " + editEintrag.getText().toString());
                    dieListe.add(editEintrag.getText().toString());
                    // refresh!
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Bitte zuerst Text eingeben", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
