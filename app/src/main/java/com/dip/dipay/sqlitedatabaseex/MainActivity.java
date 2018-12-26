package com.dip.dipay.sqlitedatabaseex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /*Step 1*/
    EditText edt_name,edt_phone,edt_add;

    DataModel dataModel; /*go for create Model Class*/

    SqliteDb sqliteDb; /*go for create Sqlite single Class which extend SqliteOpenHelper class*/

    /*Step 1*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Step 2*/
        edt_name=findViewById(R.id.edt_name);
        edt_phone=findViewById(R.id.edt_phone);
        edt_add=findViewById(R.id.edt_add);



        dataModel=new DataModel();

        sqliteDb=new SqliteDb(this);

        /*Step 2*/ /*go to SqliteDb class for Step 3*/

        /*This button Initialization with onclick is advance process*/

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataModel.setName(edt_name.getText().toString());
                dataModel.setPh(edt_phone.getText().toString());
                dataModel.setAdd(edt_add.getText().toString());

                sqliteDb.insert(dataModel);

            }
        });
        /*This button Initialization with onclick is advance process*/

        findViewById(R.id.btn_fetch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserAllListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
