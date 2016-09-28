package com.example.bharatkumar.meritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {
    MyStudentDB myStudentDB;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myStudentDB=new MyStudentDB(this,null,null,1);
        editText= (EditText) findViewById(R.id.deleteEditText);
    }

    public void submit(View view)
    {
        String username=editText.getText().toString();
        myStudentDB.deleteAccount(username);
        editText.setText("");
    }
}
