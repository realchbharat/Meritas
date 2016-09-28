package com.example.bharatkumar.meritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    MyStudentDB myStudentDB;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myStudentDB=new MyStudentDB(this,Singleton.getInstance().getString()+"studentDB.db",null,1);
        editText= (EditText) findViewById(R.id.deleteEditText);
    }

    public void delete(View view)
    {
        String username=editText.getText().toString();
        myStudentDB.deleteAccount(username);
        editText.setText("");
        Toast.makeText(this,"Deleted Successfully",Toast.LENGTH_SHORT).show();
    }
}
