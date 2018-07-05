package com.janardhan.vaish.braintenance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);

    }
    public void startQuiz(View view) {
        if(android.text.TextUtils.isEmpty(username.getText())){
            username.setError("Name is required!");
        }
        else{
            Intent startQuiz = new Intent(MainActivity.this,QuizActivity.class);
            startActivity(startQuiz);
        }
    }
}
