package ch.ibw.reto.spruchdestages;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NamensErfassungActivity extends AppCompatActivity {

    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namens_erfassung);

        // get the values from input field
        editTextName = (EditText) findViewById(R.id.edit_name);


        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("X", "Name erfasst: " + editTextName.getText().toString());



                // abspeichern Name
                if (editTextName.getText().toString() != null) {

                    // neu mit rueckgabe
                    Intent intent = new Intent();
                    intent.putExtra("nameR", editTextName.getText().toString());
                    setResult(Activity.RESULT_OK, intent);
                    finish();
/*
                    SharedPreferences prefs = getSharedPreferences("Special Prefs", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("name", editTextName.getText().toString());
                    editor.commit();

                    finish();
                    */

                }



            }
        });


    }
}
