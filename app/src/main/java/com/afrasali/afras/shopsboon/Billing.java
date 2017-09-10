package com.afrasali.afras.shopsboon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Billing extends AppCompatActivity {
    ListView things;
    int i=0;  //position of list array
    String[] Items_For_Bill;
    int[] Items_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        things=(ListView)findViewById(R.id.shopping_list);
    }
       //adapter forr list
        /*
        CustomAdapter myAdapter=new CustomAdapter();
        things.setAdapter(myAdapter);
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Items_For_Bill.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.activity_billing,null);
            TextView sno=(TextView)findViewById(R.id.bSno);
            TextView itm=(TextView)findViewById(R.id.bItem);
            TextView qty=(TextView)findViewById(R.id.bQts);
            TextView cst=(TextView)findViewById(R.id.bCost);
            sno.setText(i);
            itm.setText(i);
            qty.setText(i);
            cst.setText(i);


            return view;
        }
    }**/
    public void billAddClick(View view){
        EditText items=(EditText)findViewById(R.id.BillGetItem);
        EditText quantity=(EditText)findViewById(R.id.BillGetQty);
        try{

        Items_For_Bill[i]=items.getText().toString();
        Items_quantity[i]= Integer.parseInt(quantity.getText().toString());
        i=i+1;
//        Toast.makeText(this, "added", Toast.LENGTH_SHORT).show();

    }catch(Exception e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();

    }
}}
