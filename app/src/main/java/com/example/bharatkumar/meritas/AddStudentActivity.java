package com.example.bharatkumar.meritas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddStudentActivity extends AppCompatActivity {
    EditText sname,phno,email,address,course;
    MyStudentDB myStudentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
         sname= (EditText) findViewById(R.id.studentNameEditText);
         phno= (EditText) findViewById(R.id.phoneEditText);
        email= (EditText) findViewById(R.id.emailEditText);
        address=(EditText)findViewById(R.id.addressEditText);
        course= (EditText) findViewById(R.id.courseEditText);
        myStudentDB=new MyStudentDB(this,null,null,1);
    }

    public void cancel(View view)
    {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        finish();

    }

    public void submit(View view)
    {
        StudentAccounts accounts=new StudentAccounts(sname.getText().toString(),phno.getText().toString(),
                                                        email.getText().toString(),address.getText().toString()
                                                        ,course.getText().toString());

        boolean check=myStudentDB.addAccount(accounts);

        if(check)
        {
            Intent intent=new Intent(this,HomeActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Student Added Successfully",Toast.LENGTH_SHORT).show();
            finish();
        }

        else
        {
            Toast.makeText(this,"Student already exsist",Toast.LENGTH_SHORT).show();
        }

    }
}
