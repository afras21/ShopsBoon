package com.afrasali.afras.shopsboon;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Afras Ali on 9/8/2017.
 */
public class SaveUser extends SQLiteOpenHelper {


    public SaveUser(Context context) {
        super(context, "db", null,10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(name text,password text,phone text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }
    public int LoginCheck(String uName){
        SQLiteDatabase db=getReadableDatabase();
        String[] args={uName};
        Cursor cr=db.query("user",null,"name=?",args,null,null,null);

        return cr.getCount();
    }
    public int PCheck(String uName,String pswd){
        SQLiteDatabase db=getReadableDatabase();
        String[] args={uName,pswd};
        Cursor cr=db.query("user",null,"name=? and password=?",args,null,null,null);
        return cr.getCount();
    }
}
