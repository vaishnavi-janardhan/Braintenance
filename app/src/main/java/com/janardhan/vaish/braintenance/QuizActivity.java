package com.janardhan.vaish.braintenance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;

public class QuizActivity extends AppCompatActivity {

    ImageButton img1, img2, img3, img4, img5, img6;
    TextView mTimer,result;
    private static final String KEY_TEXT_VALUE = "textValue";
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        img1 = findViewById(R.id.hint_btn1);
        img2 = findViewById(R.id.hint_btn2);
        img3 = findViewById(R.id.hint_btn3);
        img4 = findViewById(R.id.hint_btn4);
        img5 = findViewById(R.id.hint_btn5);
        img6 = findViewById(R.id.hint_btn6);

        mTimer = findViewById(R.id.timer);

        new CountDownTimer(120000,1000){
            public void onTick(long millisUntilFinished){
                mTimer.setText(millisUntilFinished/60000 + ":" +(millisUntilFinished%60000)/1000);
            }
            public void onFinish() {
                submitAnswers();
            }
        }.start();
        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence(KEY_TEXT_VALUE);
            mTimer.setText(savedText);
        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_TEXT_VALUE, mTimer.getText());
    }

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

    public void submitAnswers(){
        Button submitButton = findViewById(R.id.submit_button);
        RadioGroup group1 = findViewById(R.id.radio1);
        RadioGroup group2 = findViewById(R.id.radio2);
        RadioGroup group3 = findViewById(R.id.radio3);
        RadioGroup group4 = findViewById(R.id.radio4);
        RadioGroup group6 = findViewById(R.id.radio6);

        int selectedId1 = group1.getCheckedRadioButtonId();
        int selectedId2 = group2.getCheckedRadioButtonId();
        int selectedId3 = group3.getCheckedRadioButtonId();
        int selectedId4 = group4.getCheckedRadioButtonId();
        int selectedId6 = group6.getCheckedRadioButtonId();

        RadioButton answer1 = findViewById(R.id.radio1_2);
        RadioButton answer2 = findViewById(R.id.radio2_1);
        RadioButton answer3 = findViewById(R.id.radio3_4);
        RadioButton answer4 = findViewById(R.id.radio4_3);

        CheckBox answer5_1 = findViewById(R.id.check1);
        CheckBox answer5_2 = findViewById(R.id.check3);
        CheckBox option2 = findViewById(R.id.check2);
        CheckBox option4 = findViewById(R.id.check4);

        RadioButton answer6_1 = findViewById(R.id.radio6_1);
        RadioButton answer6_2 = findViewById(R.id.radio6_2);
        RadioButton answer6_3 = findViewById(R.id.radio6_3);

        RadioButton selected1 = findViewById(selectedId1);
        RadioButton selected2 = findViewById(selectedId2);
        RadioButton selected3 = findViewById(selectedId3);
        RadioButton selected4 = findViewById(selectedId4);
        RadioButton selected6 = findViewById(selectedId6);

        result = findViewById(R.id.result);


        answer1.setTextColor(Color.GREEN);
        answer2.setTextColor(Color.GREEN);
        answer3.setTextColor(Color.GREEN);
        answer4.setTextColor(Color.GREEN);
        answer5_1.setTextColor(Color.GREEN);
        answer5_2.setTextColor(Color.GREEN);

        if(group1.getCheckedRadioButtonId() != -1){
            if(selectedId1 == R.id.radio1_2){
                score++;
            }
            else{
                selected1.setTextColor(Color.RED);
            }
        }
        if(group2.getCheckedRadioButtonId() != -1){

            if(selectedId2 == R.id.radio2_1){
                score++;
            }
            else{
                selected2.setTextColor(Color.RED);
            }
        }
        if(group3.getCheckedRadioButtonId() != -1){

            if(selectedId3 == R.id.radio3_4){
                score++;
            }
            else{
                selected3.setTextColor(Color.RED);
            }
        }
        if(group4.getCheckedRadioButtonId() != -1){

            if(selectedId4 == R.id.radio4_3){
                score++;
            }
            else{
                selected4.setTextColor(Color.RED);
            }
        }
        if(answer5_1.isChecked() && answer5_2.isChecked() && !option2.isChecked() && !option4.isChecked()){
            score++;
        }
        else{
            if(option2.isChecked())
                option2.setTextColor(Color.RED);
            if(option4.isChecked())
                option4.setTextColor(Color.RED);
        }

        if(score >= 0 && score <= 2 ){
            answer6_1.setTextColor(Color.GREEN);
            if(answer6_1.isChecked()){
                score++;
            }
            else{
                if(group6.getCheckedRadioButtonId() != -1 )
                    selected6.setTextColor(Color.RED);
            }
            }
        else if(score >= 3 && score <= 4 ) {
            answer6_2.setTextColor(Color.GREEN);
            if(answer6_2.isChecked())
                score++;
                else{
                    if(group6.getCheckedRadioButtonId() != -1)
                        selected6.setTextColor(Color.RED);
                }
            }
        else {
            answer6_3.setTextColor(Color.GREEN);
            if(answer6_3.isChecked()){
                score++;
            }
            else{
                if(group6.getCheckedRadioButtonId() != -1)
                    selected6.setTextColor(Color.RED);
            }
        }


        result.setVisibility(View.VISIBLE);
        result.setText("Score: " + score +"/6");

        submitButton.setVisibility(View.GONE);
        mTimer.setVisibility(View.GONE);

        for(int i=0; i < group1.getChildCount(); i++){
            group1.getChildAt(i).setEnabled(false);
        }
        for(int i=0; i < group2.getChildCount(); i++){
            group2.getChildAt(i).setEnabled(false);
        }
        for(int i=0; i < group3.getChildCount(); i++){
            group3.getChildAt(i).setEnabled(false);
        }
        for(int i=0; i < group4.getChildCount(); i++){
            group4.getChildAt(i).setEnabled(false);
        }
        for(int i=0; i < group6.getChildCount(); i++){
            group6.getChildAt(i).setEnabled(false);
        }

        answer5_1.setEnabled(false);
        answer5_2.setEnabled(false);
        option2.setEnabled(false);
        option4.setEnabled(false);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle(R.string.result);
        builder1.setMessage("Your score is " + score + "/6");
        builder1.setCancelable(true);
        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        });
        AlertDialog alert1 = builder1.create();
        alert1.show();

    }
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
