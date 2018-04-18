package com.example.amansingh.loginsignup;

import android.content.Intent;
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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                 if(name.length()!=0 && pass.length()!=0 && email.length()!=0)
                 {
                     gender = (RadioButton)findViewById(sex.getCheckedRadioButtonId());
                     Gender = gender.getText().toString();
                     Toast.makeText(getApplicationContext(),"Thanks for Registration",Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                     intent.putExtra("name",name.getText().toString());
                     intent.putExtra("pass",pass.getText().toString());
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
