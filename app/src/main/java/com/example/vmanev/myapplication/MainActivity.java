package com.example.vmanev.myapplication;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Handler().postDelayed(()-> {
                Toast.makeText(getApplicationContext(), "www", Toast.LENGTH_LONG).show();
            }
        ,7000);
    }
}

