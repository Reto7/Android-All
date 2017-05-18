package ch.ibw.reto.spruchdestages;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ch.ibw.reto.spruchdestages.app.ApplicationController;

public class MainActivity extends AppCompatActivity {


    static final int PICK_CONTACT_REQUEST = 101;  // The request code

    private TextView textViewWelcome;
    private TextView textViewSpruch;

    private Person person = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ausgabefeld
        textViewWelcome = (TextView) findViewById(R.id.label_welcome);
        textViewSpruch = (TextView) findViewById(R.id.label_spruch);

        this.person = new Person();

        // auslesen
        SharedPreferences prefs = getSharedPreferences("Special Prefs", Activity.MODE_PRIVATE);
        String name = prefs.getString("name",null);
        Log.w("X", "Name ausgelesen (1): " + name);

        //test  // TODO, hiermit gehts gleich zur namenserfassung
        //name = null;

        if (name != null) {
            this.person.setName(name);
        }

        Log.w("X", "Person: " + this.person.getName());
        if (this.person.getName() != null) {
            // Falls User bekannt (abgespeichert, dann nur Spruch)
            ausgabe();
        }
        else {
            // Falls User unbekannt, die NamensErfassung starten, dann den Namen abspeichern
            Log.w("X", "Person ist unbekannt ");
            // CALL DETAIL ACTIVITY
            Intent intent = new Intent(getApplicationContext(), NamensErfassungActivity.class);
            //intent.putExtra("KONTAKT", dieListe.get(position) );
            //startActivity(intent);
            startActivityForResult(intent, PICK_CONTACT_REQUEST);
            Log.w("X", "------------details---called-----------");  // ACHTUNG, das hier laeuft weiter !!!
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Log.w("X", "Rueckgabewert: " + extras.getString("nameR"));

                SharedPreferences prefs = getSharedPreferences("Special Prefs", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("name", extras.getString("nameR"));
                editor.commit();

                this.person.setName(extras.getString("nameR"));
                ausgabe();
            }
        }


    }

    private void ausgabe(){
        Log.w("X", "------------ausgabe-------------");
        textViewWelcome.setText("Hallo "+this.person.getName());
        //textViewSpruch.setText("Heute ist der schönste Donnerstag des Jahres");
        getDailyQuoteFromInternet();

    }

    private void getDailyQuoteFromInternet() {
        textViewSpruch.setText("Loading ...");

        // der constructor erwartet viele Parameter
        JsonObjectRequest request = new JsonObjectRequest(
                com.android.volley.Request.Method.GET,
                "http://quotes.rest/qod.json",
                (String) null,
                new Response.Listener<JSONObject>() {  /* listener verarbeitet response */   /* anonyme klasse */
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d("Response: " +response.toString());
                        String fortune = "leer";
                        //
                        try{
                            JSONObject contents = response.getJSONObject("contents");
                            JSONArray quotes = contents.getJSONArray("quotes");
                            fortune = quotes.getJSONObject(0).getString("quote");
                            // hier ausgeben, etwas unschoen !! // TODO
                            textViewSpruch.setText(fortune);  // TODO in raw file abspeichern
                        } catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {   /* anonyme klasse */
                        // TODO hier toast
                        error.printStackTrace();
                    }

                }
        );

        Log.w("X", "Request: " + request.toString());
        ApplicationController.getInstance().addToRequestQueue(request);
    }

}
