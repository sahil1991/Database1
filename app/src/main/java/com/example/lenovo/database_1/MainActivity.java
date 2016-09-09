package com.example.lenovo.database_1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Sqlite1 Mydb;
    AutoCompleteTextView text;
    EditText e1;
    Button b1;
    ArrayList<String> Liste = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Mydb=new Sqlite1(this);
        text=(AutoCompleteTextView)findViewById(R.id.auto);
        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.insert);
        b1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        boolean isInserted=Mydb.insertData(e1.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(MainActivity.this,"data inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"data not inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
        doldur();
         ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, Liste);
        text.setThreshold(1);
        text.setAdapter(arrayAdapter);

    }
    private void doldur() {
        SQLiteDatabase Db = Mydb.getReadableDatabase();
        Cursor c = Db.rawQuery("SELECT * FROM smartphones2", null);
        Db.isOpen();
        while(c.moveToNext()){
            Liste.add(c.getString(c.getColumnIndex("Product_name")));
        };


}}

