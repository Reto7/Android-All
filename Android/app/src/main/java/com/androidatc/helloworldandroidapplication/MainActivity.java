package com.androidatc.helloworldandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--> entweder als final oder dann als instanzvariablen nach oben verschieben
        // get the values from input field
        final EditText editHeight = (EditText) findViewById(R.id.edit_height);
        final EditText editWeight = (EditText) findViewById(R.id.edit_weight);
        // Ausgabefeld
        final TextView textAusgabe = (TextView) findViewById(R.id.txt_ausgabe);

        // get the button
        Button buttonCompute = (Button) findViewById(R.id.button_compute);
        buttonCompute.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float height = Float.parseFloat(editHeight.getText().toString());
                float weight = Float.parseFloat(editWeight.getText().toString());
                String ausgabe = BmiBusinessComponent.calculateBMI(weight, height);
                textAusgabe.setText(ausgabe);
            }
        });
    }


//    String getBmiResultat(float weight, float height) {
//        return BmiBusinessComponent.calculateBMI(weight, height);
//    }

}
