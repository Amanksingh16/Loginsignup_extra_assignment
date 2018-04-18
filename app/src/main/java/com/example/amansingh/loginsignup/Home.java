package com.example.amansingh.loginsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity
{
Intent intent;
TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = (TextView)findViewById(R.id.textView);
        intent = getIntent();
        user.setText(user.getText()+intent.getStringExtra("user"));
    }
}
