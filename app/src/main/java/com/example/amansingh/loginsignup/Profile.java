package com.example.amansingh.loginsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    ListView listView;
    String a[] = {"Aman Kumar Singh","amansingh16597@gmail.com","9089147446"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        adapter = new ArrayAdapter<String>(Profile.this,android.R.layout.simple_list_item_1,a);
        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("User Options");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add("Cut");
        menu.add("Copy");
        menu.add("Paste");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == "Cut")
        {
            Toast.makeText(Profile.this, "The text is on the clipboard", Toast.LENGTH_SHORT).show();
        }
        else
        if(item.getTitle() == "Copy")
        {
            Toast.makeText(Profile.this, "The text is copied on the clipboard", Toast.LENGTH_SHORT).show();
        }
        else
        if(item.getTitle() == "Paste")
        {
            Toast.makeText(Profile.this, "The text is pasted on the clipboard", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
