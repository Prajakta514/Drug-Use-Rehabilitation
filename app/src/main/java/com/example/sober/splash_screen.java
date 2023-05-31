    package com.example.sober;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.logging.LogRecord;

    public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent iHome = new Intent(splash_screen.this, LoginActivity.class);
               startActivity(iHome);
           }
       },2000);


    }
}