package com.example.bharatkumar.meritas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView= (TextView) findViewById(R.id.textView);
        ListView listView=(ListView) findViewById(R.id.list1);
        textView.setText("Welcome to Meritas "+getIntent().getStringExtra("text").toUpperCase());
        String[] options={"Add Student","Delete Student","Update Student","Show All Students","Log Out"};

        /*ArrayList<String> options=new ArrayList<String>();
        options.add("Add Student");
        options.add("Delete Student");
        options.add("Update Student");
        options.add("Show All Students");
        options.add("Log Out");*/

        ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:Intent addIntent=new Intent(HomeActivity.this,AddStudentActivity.class);
                            startActivity(addIntent);
                            break;
                    case 1:Intent deleteIntent=new Intent(HomeActivity.this,DeleteActivity.class);
                            startActivity(deleteIntent);
                            break;
                    case 2:Intent updateIntent=new Intent(HomeActivity.this,UpdateActivity.class);
                            startActivity(updateIntent);
                            break;
                    case 3:Intent allIntent=new Intent(HomeActivity.this,AllDataActivity.class);
                            startActivity(allIntent);
                            break;

                    default:Intent logOutIntent=new Intent(HomeActivity.this,MainActivity.class);
                            startActivity(logOutIntent);
                            Toast.makeText(HomeActivity.this,"Logging Out",Toast.LENGTH_SHORT).show();
                            finish();
                            break;
                }

            }
        });

    }


}
