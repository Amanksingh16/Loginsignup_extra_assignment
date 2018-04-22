package com.example.amansingh.loginsignup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
      EditText name , pass;
      Button login;
      SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        login = (Button)findViewById(R.id.login);
        s = getSharedPreferences("details", Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             if(name.length()!=0 && pass.length()!=0)
             {
                if (name.getText().toString().equals(s.getString("name","default"))&&(pass.getText().toString().equalsIgnoreCase(s.getString("pass","default"))))
                 {
                    Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Home.class);
                    startActivity(i);
                    finish();
                }
                else
                    {
                    Toast.makeText(getApplicationContext(), "Username or password is not correct", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(i);
                }
            }
                else
                {
                    Toast.makeText(getApplicationContext(),"Register here",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}
