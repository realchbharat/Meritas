package com.example.bharatkumar.meritas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
