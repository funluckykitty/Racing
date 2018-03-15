package com.example.android.ims;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Spinner Code found at https://developer.android.com/guide/topics/ui/controls/spinner.html
        Spinner spinner = (Spinner) findViewById(R.id.spinner_trophy);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trophy_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void btnGradeQuiz(View v) {
        String yearAnswer = "1911";
        String trophyAnswer = "Borg-Warner Trophy";
        String plural = "";
        int correctAnswers = 0;

//Q1 is required.  Check to see if it equal the default string value.
        String strTxtYear = ((TextView) findViewById(R.id.txtYear)).getText().toString();
        if (strTxtYear.equals("")) {
            Toast.makeText(getApplicationContext(), "Question 1 is required!", Toast.LENGTH_SHORT).show();
        }
        if (strTxtYear.equals(yearAnswer)) {
            correctAnswers += 1;
        }
//Q2 has radio buttons.  Only add to score if correct value of 25 is checked.
        RadioButton rbDistance2 = (RadioButton) findViewById(R.id.distance2);
        Boolean hasrbDistance2 = rbDistance2.isChecked();

        RadioButton rbDistance25 = (RadioButton) findViewById(R.id.distance25);
        Boolean hasrbDistance25 = rbDistance25.isChecked();
        if (hasrbDistance25 == true) {
            correctAnswers += 1;
        }
        RadioButton rbDistance3 = (RadioButton) findViewById(R.id.distance3);
        Boolean hasrbDistance3 = rbDistance3.isChecked();

//Q3 has checkboxes.  Only add to the score if all drivers are checked.
        CheckBox driver1 = (CheckBox) findViewById(R.id.driver1);
        Boolean hasrbdriver1 = driver1.isChecked();

        CheckBox driver2 = (CheckBox) findViewById(R.id.driver2);
        boolean hasrbdriver2 = driver2.isChecked();

        CheckBox driver3 = (CheckBox) findViewById(R.id.driver3);
        boolean hasrbdriver3 = driver3.isChecked();

        if ((hasrbdriver1) && (hasrbdriver2) && (hasrbdriver3)) {
            correctAnswers += 1;
        }
//Q4 has a spinner.  Only add to the score if the selected item equals the default string value
        Spinner spinner = (Spinner) findViewById(R.id.spinner_trophy);
        String spinnerAnswer = spinner.getSelectedItem().toString();
        if (spinnerAnswer.equals(trophyAnswer)) {
            correctAnswers += 1;
        }

        if (correctAnswers == 1) {
            plural = "";
        } else {
            plural = "s";
        }

        if (correctAnswers == 4) {
            Toast.makeText(getApplicationContext(), "Congratulations! You answered all the questions correctly.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), String.valueOf(correctAnswers) + " Correct answer" + plural, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnResetQuiz(View v) {
    }


}