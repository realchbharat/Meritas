package com.example.bharatkumar.meritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText studentText,phoneText,emailText,addresText,courseText;
    MyStudentDB myStudentDB;
    String sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myStudentDB=new MyStudentDB(this,Singleton.getInstance().getString()+"studentDB.db",null,1);
    }

    public void find(View view)
    {
        studentText= (EditText) findViewById(R.id.studentNameEditText);
        sname=studentText.getText().toString();

        StudentAccounts account=myStudentDB.findData(sname);

        phoneText= (EditText) findViewById(R.id.phoneEditText);
        phoneText.setText(account.get_phone());
        emailText= (EditText) findViewById(R.id.emailEditText);
        emailText.setText(account.get_email());
        addresText= (EditText) findViewById(R.id.addressEditText);
        addresText.setText(account.get_address());
        courseText= (EditText) findViewById(R.id.courseEditText);
        courseText.setText(account.get_course());
    }

    public void update(View view)
    {
        String phone=phoneText.getText().toString();
        String email=emailText.getText().toString();
        String address=addresText.getText().toString();
        String course=courseText.getText().toString();
    myStudentDB.updateContact(sname,phone,email,address,course);
        Toast.makeText(this,"Updated Successfully",Toast.LENGTH_SHORT).show();
    }
}
