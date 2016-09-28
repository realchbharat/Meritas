package com.example.bharatkumar.meritas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AllDataActivity extends AppCompatActivity {

    MyStudentDB myStudentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);

        myStudentDB=new MyStudentDB(this,Singleton.getInstance().getString()+"studentDB.db",null,1);
        ArrayList<StudentAccounts> account=myStudentDB.allData();

        CustomAdapter adapter= new CustomAdapter(this,account);
        ListView listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }


}
