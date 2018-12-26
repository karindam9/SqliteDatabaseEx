package com.dip.dipay.sqlitedatabaseex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class UserAllListActivity extends AppCompatActivity {

    ArrayList<DataModel> arrayList;
    ListView list;
    SqliteDb dataBaseHelper;

    CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_list);

        list=findViewById(R.id.list);

        arrayList=new ArrayList<>();

        dataBaseHelper=new SqliteDb(this);

        arrayList=dataBaseHelper.getAllUser();  /*step 5*/

        customAdapter=new CustomAdapter(this,arrayList);   /*step 6*/

        list.setAdapter(customAdapter);




    }
}
