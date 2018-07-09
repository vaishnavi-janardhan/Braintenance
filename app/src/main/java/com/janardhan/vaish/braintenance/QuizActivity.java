package com.janardhan.vaish.braintenance;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuizActivity extends AppCompatActivity {

    Unbinder unbinder;

    @BindView(R.id.timer)
    TextView mTimerTextView;
    @BindView(R.id.result)
    TextView resultTextView;
    @BindView(R.id.submit_button)
    Button submitButton;

    private static final String KEY_TEXT_VALUE = "textValue";
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // bind the view using butterknife
        ButterKnife.bind(this);


        /**
         * Timer indicating time left in the format mm:ss
         * Submit answers when timer ends
         */
        new CountDownTimer(120000,1000){
            public void onTick(long millisUntilFinished){
                mTimerTextView.setText(millisUntilFinished / 60000 + ":" + (millisUntilFinished % 60000) / 1000);
            }
            public void onFinish() {
                submitAnswers();
            }
        }.start();

        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            mTimerTextView.setText(savedText);
        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, mTimerTextView.getText());
    }

    /**
     * Show hints in the form of toast
     *
     * @param view
     */
    public void showHint1(View view) {
        Toast hint = Toast.makeText(this, R.string.hint1,Toast.LENGTH_SHORT);
        hint.show();
    }
    public void showHint2(View view) {
        Toast hint = Toast.makeText(this, R.string.hint2,Toast.LENGTH_SHORT);
        hint.show();
    }
    public void showHint3(View view) {
        Toast hint = Toast.makeText(this, R.string.hint3,Toast.LENGTH_SHORT);
        hint.show();
    }
    public void showHint4(View view) {
        Toast hint = Toast.makeText(this, R.string.hint4,Toast.LENGTH_SHORT);
        hint.show();
    }
    public void showHint5(View view) {
        Toast hint = Toast.makeText(this, R.string.hint5,Toast.LENGTH_SHORT);
        hint.show();
    }
    public void showHint6(View view) {
        Toast hint = Toast.makeText(this, R.string.hint6,Toast.LENGTH_SHORT);
        hint.show();
    }

    public void submit(View view) {
        submitAnswers();
    }

    /**
     * Submit answers after validation
     */
    public void submitAnswers() {

        RadioGroup radioGroup1 = findViewById(R.id.radio1);
        EditText editTextAns2 = findViewById(R.id.answer2);
        RadioGroup radioGroup3 = findViewById(R.id.radio3);
        RadioGroup radioGroup4 = findViewById(R.id.radio4);
        RadioGroup radioGroup6 = findViewById(R.id.radio6);

        int selectedRadioId1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRadioId3 = radioGroup3.getCheckedRadioButtonId();
        int selectedRadioId4 = radioGroup4.getCheckedRadioButtonId();
        int selectedRadioId6 = radioGroup6.getCheckedRadioButtonId();

        RadioButton radioButtonAns1 = findViewById(R.id.radio1_2);
        RadioButton radioButtonAns3 = findViewById(R.id.radio3_4);
        RadioButton radioButtonAns4 = findViewById(R.id.radio4_3);

        CheckBox checkBoxAns5_1 = findViewById(R.id.check1);
        CheckBox checkBoxAns5_2 = findViewById(R.id.check3);
        CheckBox checkBoxOpt2 = findViewById(R.id.check2);
        CheckBox checkBoxOpt4 = findViewById(R.id.check4);

        RadioButton radioButton6_1 = findViewById(R.id.radio6_1);
        RadioButton radioButton6_2 = findViewById(R.id.radio6_2);
        RadioButton radioButton6_3 = findViewById(R.id.radio6_3);

        RadioButton radioButtonSelected1 = findViewById(selectedRadioId1);
        RadioButton radioButtonSelected3 = findViewById(selectedRadioId3);
        RadioButton radioButtonSelected4 = findViewById(selectedRadioId4);
        RadioButton radioButtonSelected6 = findViewById(selectedRadioId6);

        resultTextView = findViewById(R.id.result);

        radioButtonAns1.setTextColor(Color.GREEN);
        radioButtonAns3.setTextColor(Color.GREEN);
        radioButtonAns4.setTextColor(Color.GREEN);
        checkBoxAns5_1.setTextColor(Color.GREEN);
        checkBoxAns5_2.setTextColor(Color.GREEN);

        if (radioGroup1.getCheckedRadioButtonId() != -1) {
            if (selectedRadioId1 == R.id.radio1_2) {
                score++;
            } else {
                radioButtonSelected1.setTextColor(Color.RED);
            }
        }
        if (editTextAns2.getText().toString().equals("Tuesday") || editTextAns2.getText().toString().equals("tuesday")) {
            score++;
            editTextAns2.setTextColor(Color.GREEN);
        } else {
            editTextAns2.setTextColor(Color.RED);
        }
        if (radioGroup3.getCheckedRadioButtonId() != -1) {

            if (selectedRadioId3 == R.id.radio3_4) {
                score++;
            } else {
                radioButtonSelected3.setTextColor(Color.RED);
            }
        }
        if (radioGroup4.getCheckedRadioButtonId() != -1) {

            if (selectedRadioId4 == R.id.radio4_3) {
                score++;
            } else {
                radioButtonSelected4.setTextColor(Color.RED);
            }
        }
        if (checkBoxAns5_1.isChecked() && checkBoxAns5_2.isChecked() && !checkBoxOpt2.isChecked() && !checkBoxOpt4.isChecked()) {
            score++;
        } else {
            if (checkBoxOpt2.isChecked()) checkBoxOpt2.setTextColor(Color.RED);
            if (checkBoxOpt4.isChecked()) checkBoxOpt4.setTextColor(Color.RED);
        }

        if (score >= 0 && score <= 2) {
            radioButton6_1.setTextColor(Color.GREEN);
            if (radioButton6_1.isChecked()) {
                score++;
            } else {
                if (radioGroup6.getCheckedRadioButtonId() != -1)
                    radioButtonSelected6.setTextColor(Color.RED);
            }
        } else if (score >= 3 && score <= 4) {
            radioButton6_2.setTextColor(Color.GREEN);
            if (radioButton6_2.isChecked()) score++;
            else {
                if (radioGroup6.getCheckedRadioButtonId() != -1)
                    radioButtonSelected6.setTextColor(Color.RED);
            }
        } else {
            radioButton6_3.setTextColor(Color.GREEN);
            if (radioButton6_3.isChecked()) {
                score++;
            } else {
                if (radioGroup6.getCheckedRadioButtonId() != -1)
                    radioButtonSelected6.setTextColor(Color.RED);
            }
        }


        resultTextView.setVisibility(View.VISIBLE);
        resultTextView.setText("Score: " + score + "/6");

        submitButton.setVisibility(View.GONE);
        mTimerTextView.setVisibility(View.GONE);

        for (int i = 0; i < radioGroup1.getChildCount(); i++) {
            radioGroup1.getChildAt(i).setEnabled(false);
        }
        editTextAns2.setEnabled(false);
        for (int i = 0; i < radioGroup3.getChildCount(); i++) {
            radioGroup3.getChildAt(i).setEnabled(false);
        }
        for (int i = 0; i < radioGroup4.getChildCount(); i++) {
            radioGroup4.getChildAt(i).setEnabled(false);
        }
        for (int i = 0; i < radioGroup6.getChildCount(); i++) {
            radioGroup6.getChildAt(i).setEnabled(false);
        }

        checkBoxAns5_1.setEnabled(false);
        checkBoxAns5_2.setEnabled(false);
        checkBoxOpt2.setEnabled(false);
        checkBoxOpt4.setEnabled(false);

        Toast.makeText(this, "Your score is " + score + "/6", Toast.LENGTH_SHORT).show();

    }

    /**
     * Pops up dialog when the back button is pressed
     */
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(R.string.warning);
        builder2.setMessage(R.string.warning_text);
        builder2.setCancelable(false);
        builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                QuizActivity.this.finish();
            }
        });
        builder2.setNegativeButton("No",null);
        AlertDialog alert2 = builder2.create();
        alert2.show();
    }

}
