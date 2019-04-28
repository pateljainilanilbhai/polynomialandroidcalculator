package com.example.jainil.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class help extends AppCompatActivity {
    RatingBar b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       b=(RatingBar) findViewById(R.id.ratingBar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
        public void onrate(View v)
    {
        float n=b.getRating();
        Context context=getApplicationContext();
        Toast toast=Toast.makeText(context,"Thanks for rating us "+n+" Stars",Toast.LENGTH_SHORT);
        toast.show();
        Intent i=new Intent("com.example.jainil.myapplication.feedback");
        startActivity(i);
    }
}


