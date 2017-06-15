package test.reto.geolocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____GEOLOCATION";
    TextView textViewShow;
    Button buttonGet;

    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
    // app-defined int constant. The callback method gets the
    // result of the request.
    private static final int MY_PERMISSION_ACCESS_FINE_LOCATION = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textViewShow = (TextView) findViewById(R.id.showText);
        buttonGet = (Button) findViewById(R.id.buttonGet);

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
                startCapturingLocation();
            }
        });
    }

    private void startCapturingLocation() {
        Log.w(PROG, "start capturing location ...");

        if ( ContextCompat.checkSelfPermission( this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            Log.w(PROG, "not granted");
            ActivityCompat.requestPermissions( this, new String[] {  Manifest.permission.ACCESS_FINE_LOCATION  },
                    MY_PERMISSION_ACCESS_FINE_LOCATION);
            Log.w(PROG, "request permission fertig");
        } else {
            Log.w(PROG, "granted");
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Log.w(PROG, "locationmanager : " +locationManager);
        //
        Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastKnownLocation != null) {
            String message = String.format(
                    "Location captured:%nLON %s / LAT %s",
                    lastKnownLocation.getLongitude(),
                    lastKnownLocation.getLatitude()
            );
            textViewShow.setText(message);
        }
            //
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 0L, 0.0F,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.w(PROG, "location changed !");
                        Log.w(PROG, "location long : " +location.getLongitude());
                        String message = String.format(
                                "Location captured:%nLON %s / LAT %s",
                                location.getLongitude(),
                                location.getLatitude()
                        );
                        textViewShow.setText(message);
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                }
        );
    } //startCapturingLocation




    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        System.out.println("1");
        switch (requestCode) {
            case MY_PERMISSION_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays arACCESS_FINE_LOCATIONe empty.
                System.out.println("2");
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
