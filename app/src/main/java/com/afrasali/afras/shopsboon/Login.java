package com.afrasali.afras.shopsboon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
TextView t;
    RelativeLayout rw,r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rw=(RelativeLayout)findViewById(R.id.rw);
        r1=(RelativeLayout)findViewById(R.id.r1);
        rw.setVisibility(View.GONE);
        r1.setVisibility(View.VISIBLE);
    }
    public void newRegClick(View view){
        Intent i=new Intent(Login.this,Registration.class);
        startActivity(i);
    }
    public void LoginClick(View view){
    SaveUser s=new SaveUser(this);
        EditText userName=(EditText)findViewById(R.id.GetUser);
        EditText password=(EditText)findViewById(R.id.GetPwd);
        String uName=userName.getText().toString();
        String pswd=password.getText().toString();
        t=(TextView)findViewById(R.id.warn);

        int count;
        count=s.LoginCheck(uName);

        if (count==0){
            Toast.makeText(this, "Incorrect UserName", Toast.LENGTH_SHORT).show();
            rw.setVisibility(View.VISIBLE);
            t.setText("The email address you have enterd doesnot match any account ,signUp for an account");


        }
        else{
            int count1=s.PCheck(uName,pswd);
            if(count1==0){
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            }
            else {
                rw.setVisibility(View.GONE);


                Intent i=new Intent(Login.this,Billing.class);
                i.putExtra("name",uName);
                i.putExtra("password",pswd);
                startActivity(i);
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
