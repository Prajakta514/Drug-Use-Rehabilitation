package com.example.sober;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"Drug_Database", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1="create table IF NOT Exists users(username text primary key ,email text,password text,age text,gender text,location text,ph_no text)";
        String qry2="create table IF NOT Exists u_drug(username text ,drugname text,drugduration text,drugamt text)";
        String qry3="create table IF NOT Exists Rehab(r_no varchar ,name varchar,location varchar, ph_no varchar)";
        String qry4="create table IF NOT Exists Allot(username text,r_no varchar )";

       sqLiteDatabase.execSQL(qry1);
        sqLiteDatabase.execSQL(qry2);
        sqLiteDatabase.execSQL(qry3);
        sqLiteDatabase.execSQL(qry4);

//        SQLiteDatabase db =this.getWritableDatabase();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public void register(String username,String email,String password,Integer age,String gender,String location,Integer ph_no)//create explicit reg function
    {
        ContentValues cv =new ContentValues();//obj create
        cv.put("username",username);     //put values in contentvalue
        cv.put("email",email);
        cv.put("password",password);
        cv.put("age", (Integer) age);
        cv.put("gender",gender);
        cv.put("location",location);
        cv.put("ph_no", (Integer) ph_no);
        SQLiteDatabase db =this.getWritableDatabase();
        db.insert("users",null,cv);

//        db.close();
    }
    public void quiz(String username,String dname,String drugduration,String drugamt)//create explicit reg function
    {
        ContentValues cv =new ContentValues();//obj create
//        cv.put("username",username);     //put values in contentvalue
//        cv.put("Drug name",dname);
//        cv.put("Intake Duration",drugduration);
//        cv.put("Intake Amount",drugamt);

//        SQLiteDatabase db1 =getWritableDatabase(); //creating obj to database
        SQLiteDatabase db1 =this.getWritableDatabase();
//        db1.insert("Allot",null,cv);
        db1.execSQL("insert into u_drug values('"+username+"','"+dname+"','"+drugduration+"','"+drugamt+"')");
//        db1.close();
    }
    public void allot(String username,String r_no)//create explicit reg function
    {
        ContentValues cv =new ContentValues();//obj create
//        cv.put("username",username);     //put values in contentvalue
//        cv.put("Drug name",dname);
//        cv.put("Intake Duration",drugduration);
//        cv.put("Intake Amount",drugamt);

//        SQLiteDatabase db1 =getWritableDatabase(); //creating obj to database
        SQLiteDatabase db1 =this.getWritableDatabase();
        db1.insert("Allot",null,cv);
//        db1.insert("u_drug",null,cv);
        db1.execSQL("insert into Allot values('"+username+"','"+r_no+"')");
//        db1.close();
    }
    public void Rehab()//create explicit reg function String R_no,String name,String Location,String Ph_no
    {
        ContentValues cv =new ContentValues();//obj create

//        SQLiteDatabase db1 =getWritableDatabase(); //creating obj to database
        SQLiteDatabase db1 =this.getWritableDatabase();
//        db1.insert("u_drug",null,cv);
        db1.execSQL("insert into Rehab values('1','LifeLine','Pune','9820664345')");
//        db1.close();
    }


    public int login(String username ,String password)
    {
        int result=0;
        String str[] =new String[2];
        str[0] =username;
        str[1]=password;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c =db.rawQuery( "select * from users where username=? and password=?",str);
        if(c.moveToFirst()){        //if there is record
            result=1;
        }
//        db.close();
        return result;
    }
}
