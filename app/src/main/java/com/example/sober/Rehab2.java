package com.example.sober;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Rehab2 extends AppCompatActivity {
    Button btn;
    Button btn2,btn3,btn4,rbtn;
    EditText username,r_no1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab22);

        btn = findViewById(R.id.buttonpune);
        btn2= findViewById(R.id.buttonmumb);
        btn3= findViewById(R.id.buttonnagpur);
        btn4 = findViewById(R.id.buttonnashik);
        rbtn = findViewById(R.id.rsubmit);
        username = findViewById(R.id.username1);
        r_no1 = findViewById(R.id.r_no);

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Rehab2.this, NavigationActivity.class));

                String user2 = username.getText().toString();
                String r_no2 = r_no1.getText().toString();
                Database db1=new Database(getApplicationContext() ,"Drug_Database",null,1);
//                db1=new Database(this);
                db1.allot(user2,r_no2);


            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rehab2.this, rehab_pune.class));

            }

        } );
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rehab2.this, rehab_mumbai.class));

                }

        } );
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rehab2.this, rehab_nagpur.class));

            }

        } );
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Rehab2.this, rehab_nashik.class));

            }

        } );

    }
}