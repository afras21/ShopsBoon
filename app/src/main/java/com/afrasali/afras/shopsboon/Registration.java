package com.afrasali.afras.shopsboon;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.x;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }



    public void RCK(View view) {
        EditText regname = (EditText) findViewById(R.id.RName);
        EditText regpwd = (EditText) findViewById(R.id.RPassword);
        EditText regphone = (EditText) findViewById(R.id.RPhone);
        EditText regDate = (EditText) findViewById(R.id.RDate);

        //to String
        String usertxt = regname.getText().toString();
        String pwdtxt = regpwd.getText().toString();
        String phonetxt=regphone.getText().toString();


        SaveUser saveUser = new SaveUser(this);

        //inserting values
        ContentValues c = new ContentValues();
        c.put("name", usertxt);
        c.put("password", pwdtxt);
        c.put( "phone", phonetxt);
        Log.e(":sd",":"+usertxt);

        SQLiteDatabase db = saveUser.getWritableDatabase();
        long row = db.insert("user", null, c);
        //inserted row
        Log.e("here",":"+row);
        Toast.makeText(this, "" + row, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Successfully Registerd " , Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Registration.this,Login.class);
        startActivity(i);

        //result checking
        /**
        if(row>1){

            db = saveUser.getReadableDatabase();
            String[] columns={"name","password"};
            Cursor cr=db.query("user",columns,null,null,null,null,null);

            while(cr.moveToNext()){
                Toast.makeText(this, ""+cr.getString(0)+cr.getString(1), Toast.LENGTH_SHORT).show();
                Log.e("name"+cr.getString(0),"pwd:"+cr.getString(1));
            }
        }**/
    }
}
