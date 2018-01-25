package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public double numberInMinutes;
    public double decimalPlaces = 2.;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        int errorValue = 0;
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText result = (EditText) findViewById(R.id.result);

        try {
            numberInMinutes = Math.round((Integer.parseInt(editText.getText().toString())) *(Math.pow(10.,decimalPlaces))/ 60.)/(Math.pow(10.,decimalPlaces));
        } catch (NumberFormatException ex) {
            errorValue = 1;
        }
        if (errorValue == 1) {
            result.setText("Please enter an integer!");
        } else {
            String numString = "" + numberInMinutes;
            result.setText(numString);
        }
    }
}
