package com.example.sober;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Quiz extends AppCompatActivity {
    EditText username,drug_name,duration,amount;
    Database db1;
    Button qbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        username = findViewById(R.id.quser);
        drug_name = findViewById(R.id.qdname);
        duration = findViewById(R.id.qintakeDur);
        amount = findViewById(R.id.qintakeamt);
        qbtn = findViewById(R.id.qbutton);

        qbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user = username.getText().toString();
                String d_name = drug_name.getText().toString();
                String dur = duration.getText().toString();
                String amt = amount.getText().toString();
                Database db1=new Database(getApplicationContext() ,"Drug_Database",null,1);
//                db1=new Database(this);
                db1.quiz(user,d_name,dur,amt);
                startActivity(new Intent( Quiz.this,profile2.class));

            }
        });
    }
}