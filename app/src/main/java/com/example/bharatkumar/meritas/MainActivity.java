package com.example.bharatkumar.meritas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    MyRegistrationDB myRegistrationDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRegistrationDB=new MyRegistrationDB(this,null,null,1);
        username= (EditText) findViewById(R.id.userNameEditText);
        password= (EditText) findViewById(R.id.passwordEditText);
    }

    public void login(View view)
    {
        String userName=username.getText().toString();
        String passWord=password.getText().toString();
        RegisteredAccounts account=myRegistrationDB.findPassword(userName);

        if(passWord.equals(account.get_password()) && !account.get_password().equals(null))
        {
            Intent intent=new Intent(view.getContext(),HomeActivity.class);
            intent.putExtra("text", account.get_firstname());
            startActivity(intent);
            finish();
        }
        else
        Toast.makeText(this,"Username or Password is wrong or mismatched",Toast.LENGTH_LONG).show();
    }

    public void newUser(View view)
    {
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }

    public void cancel(View view)
    {
        finish();
    }
}
