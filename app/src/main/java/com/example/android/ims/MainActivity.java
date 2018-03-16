package com.example.android.ims;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    String yearAnswer = "1911";
    String trophyAnswer = "Borg-Warner Trophy";
    String plural = "";
    String strTxtYear;

    RadioGroup distance;

    RadioButton rbDistance2;
    RadioButton rbDistance25;
    RadioButton rbDistance3;

    CheckBox driver1;
    CheckBox driver2;
    CheckBox driver3;

    Spinner spinner;

    TextView txtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Spinner Code found at https://developer.android.com/guide/topics/ui/controls/spinner.html
         spinner = (Spinner) findViewById(R.id.spinner_trophy);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.trophy_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void btnGradeQuiz(View v) {
        int correctAnswers = 0;

//Q1 is required.  Check to see if it equal the default string value.
        strTxtYear = ((TextView) findViewById(R.id.txtYear)).getText().toString();
        if (strTxtYear.equals("")) {
            Toast.makeText(getApplicationContext(), "Question 1 is required!", Toast.LENGTH_SHORT).show();
        }
        if (strTxtYear.equals(yearAnswer)) {
            correctAnswers += 1;
        }
//Q2 has radio buttons.  Only add to score if correct value of 25 is checked.
        rbDistance2 = (RadioButton) findViewById(R.id.distance2);
        Boolean hasrbDistance2 = rbDistance2.isChecked();

        rbDistance25 = (RadioButton) findViewById(R.id.distance25);
        Boolean hasrbDistance25 = rbDistance25.isChecked();
        if (hasrbDistance25 == true) {
            correctAnswers += 1;
        }
        rbDistance3 = (RadioButton) findViewById(R.id.distance3);
        Boolean hasrbDistance3 = rbDistance3.isChecked();

//Q3 has checkboxes.  Only add to the score if all drivers are checked.
        driver1 = (CheckBox) findViewById(R.id.driver1);
        Boolean hasrbdriver1 = driver1.isChecked();

        driver2 = (CheckBox) findViewById(R.id.driver2);
        boolean hasrbdriver2 = driver2.isChecked();

        driver3 = (CheckBox) findViewById(R.id.driver3);
        boolean hasrbdriver3 = driver3.isChecked();

        if ((hasrbdriver1) && (hasrbdriver2) && (hasrbdriver3)) {
            correctAnswers += 1;
        }
//Q4 has a spinner.  Only add to the score if the selected item equals the default string value
        spinner = (Spinner) findViewById(R.id.spinner_trophy);
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

   //Clear all the values to Reset the Quiz
    public void btnReset(View v) {
        txtYear = ((TextView) findViewById(R.id.txtYear));
        txtYear.setText("");

        distance = (RadioGroup)findViewById(R.id.distance);
        distance.clearCheck();

       if (driver1.isChecked()) {
               driver1.setChecked(false);
       }
        if (driver2.isChecked()) {
            driver2.setChecked(false);
        }
        if (driver3.isChecked()) {
            driver3.setChecked(false);
        }
        spinner.setSelection(0);
    }
}