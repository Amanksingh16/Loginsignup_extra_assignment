package com.example.amansingh.loginsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
      Intent i;
      EditText name , pass;
      Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = getIntent();
        name = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((i.hasExtra("name"))&&(i.hasExtra("pass")))
                {
                     if(name.getText().toString().equals(i.getStringExtra("name"))&&pass.getText().toString().equalsIgnoreCase(i.getStringExtra("pass")))
                     {
                         Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                         Intent i = new Intent(MainActivity.this,Home.class);
                         i.putExtra("user",name.getText().toString());
                         startActivity(i);
                     }
                     else
                     {
                         Toast.makeText(getApplicationContext(),"Username or password is not correct",Toast.LENGTH_SHORT).show();
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
