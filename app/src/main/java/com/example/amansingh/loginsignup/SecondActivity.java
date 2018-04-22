package com.example.amansingh.loginsignup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    EditText name,pass,email;
    RadioGroup sex;
    RadioButton gender;
    String Gender;
    Button register;
    SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        sex = (RadioGroup)findViewById(R.id.radioSex);
        register = (Button)findViewById(R.id.register);
        s = getSharedPreferences("details", Context.MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 if(name.length()!=0 && pass.length()!=0 && email.length()!=0)
                 {
                     gender = (RadioButton)findViewById(sex.getCheckedRadioButtonId());
                     Gender = gender.getText().toString();
                     s.edit().putString("name",name.getText().toString()).commit();
                     s.edit().putString("pass",pass.getText().toString()).commit();
                     s.edit().putString("email",email.getText().toString()).commit();
                     s.edit().putString("gender",Gender).commit();
                     Toast.makeText(getApplicationContext(),"Thanks for Registration",Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                     startActivity(intent);
                     finish();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(),"Wrong Input",Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
}
