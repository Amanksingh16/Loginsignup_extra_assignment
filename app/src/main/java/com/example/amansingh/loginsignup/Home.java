package com.example.amansingh.loginsignup;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity
{
SharedPreferences s;
TextView user , user2 ,user3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = (TextView)findViewById(R.id.textView);
        user2 = (TextView)findViewById(R.id.textView2);
        user3 = (TextView)findViewById(R.id.textView3);
        s = getSharedPreferences("details", Context.MODE_PRIVATE);
        user.setText(user.getText()+s.getString("name","default"));
        user2.setText(user2.getText()+s.getString("gender","default"));
        user3.setText(user3.getText()+s.getString("email","default"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.profile:
                Toast.makeText(Home.this, "This is my profile", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Home.this,Profile.class);
                startActivity(i);
                break;
            case R.id.settings:
                startActivityForResult(new Intent(Settings.ACTION_SETTINGS),0);
                break;
            case R.id.logout:
                Toast.makeText(Home.this, "You are Logged out", Toast.LENGTH_SHORT).show();
                logout();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        logout();
    }

    private void logout()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(Home.this);
        alert.setTitle("Warning");
        alert.setMessage("Are you Sure you want to exit?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Home.this.finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(Home.this, "That was my mistake i know", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }
}
