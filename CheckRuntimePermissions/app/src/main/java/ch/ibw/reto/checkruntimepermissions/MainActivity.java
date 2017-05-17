package ch.ibw.reto.checkruntimepermissions;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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

    public Activity thisActivity = this;

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

                    /*
                    If the app has the permission, the method returns PackageManager.PERMISSION_GRANTED,
                    and the app can proceed with the operation. If the app does not have the permission,
                    the method returns PERMISSION_DENIED, and the app has to explicitly ask the user for permission.
                    ---
                    If your app needs a dangerous permission that was listed in the app manifest,
                    it must ask the user to grant the permission.
                     */
                    int permissionCheck = checkSelfPermission(Manifest.permission.READ_CONTACTS);
                    String resulat;
                    if (permissionCheck==PackageManager.PERMISSION_GRANTED) {
                        resulat = "GRANTED";
                    } else {
                        resulat = "DENIED";
                        //  Request-Permission !! User fragen
                        final Context context = getApplicationContext();
                        final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 1001;
//                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
//                            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.WRITE_CALENDAR)) {
//                                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
//                                alertBuilder.setCancelable(true);
//                                alertBuilder.setMessage("Write calendar permission is necessary to write event!!!");
//                                alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
//                                    }
//                                });
//                            } else {
//                                ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.WRITE_CALENDAR}, MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
//                            }
//                        }

//                        // Should we show an explanation?
//                        //if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,Manifest.permission.READ_CONTACTS)) {
//                            // Show an explanation to the user *asynchronously* -- don't block
//                            // this thread waiting for the user's response! After the user
//                            // sees the explanation, try again to request the permission.
//                        //} else {
//                            // No explanation needed, we can request the permission.
//                            ActivityCompat.requestPermissions(thisActivity,
//                                    new String[]{Manifest.permission.READ_CONTACTS},
//                                    1);
//                            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
//                            // app-defined int constant. The callback method gets the
//                            // result of the request.
//                        //}
                    }
                    textAusgabe.setText(diePermission +":" + resulat);
                } else {
                    Toast.makeText(getApplicationContext(), "Bitte zuerst eine zu prüfende Permission eingeben", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
