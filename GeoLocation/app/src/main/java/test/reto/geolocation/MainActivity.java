package test.reto.geolocation;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PROG = "____GEOLOCATION";
    TextView textViewShow;
    Button buttonGet;

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

    }
}
