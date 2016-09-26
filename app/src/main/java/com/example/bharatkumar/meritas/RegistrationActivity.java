package com.example.bharatkumar.meritas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstname;
    EditText lastname;
    EditText phone;
    EditText email;
    EditText username;
    EditText password;
    MyRegistrationDB myRegistrationDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstname= (EditText) findViewById(R.id.firstNameEditText);
        lastname= (EditText) findViewById(R.id.lastNameEditText);
        phone= (EditText) findViewById(R.id.phoneEditText);
        email= (EditText) findViewById(R.id.emailEditText);
        username=(EditText) findViewById(R.id.userNameEditText);
        password=(EditText) findViewById(R.id.passwordEditText);

        myRegistrationDB = new MyRegistrationDB(this,null,null,1);

    }

    public  void cancel(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void submit(View view)
    {
        RegisteredAccounts account=new RegisteredAccounts(firstname.getText().toString(),lastname.getText().toString(),
                                                            phone.getText().toString(),email.getText().toString(),
                                                            username.getText().toString(),password.getText().toString()
                                                            );

        boolean dbAdded=myRegistrationDB.addAccount(account);

        if(dbAdded)
            Toast.makeText(this,"data is submitted",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"username already exsists",Toast.LENGTH_SHORT).show();

    }


}
