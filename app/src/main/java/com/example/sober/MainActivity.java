package com.example.sober;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database d=new Database(this," ",null,1);
        d.Rehab();


    }

//    Database d=new Database(this," ",null,1);
//      d.openDatabase();
    public void GetTextFromSQL(View v){
        TextView tx1=(TextView) findViewById(R.id.editTextRegUsername);
        TextView tx2=(TextView) findViewById(R.id.editTextRegPassword);

        try{
            ConnectionHelper connectionHelper= new ConnectionHelper();
            connect=connectionHelper.connectionclass();
            if(connect!=null)
            {
                String query="Select * from user1";
                Statement st= connect.createStatement();
                ResultSet rs= st.executeQuery(query);
                while(rs.next())
                {
                    tx1.setText(rs.getString(1));
                    tx1.setText(rs.getString(2));
                }
            }
        }
        catch(Exception ex)
        {

        }


    }

}