package com.example.bharatkumar.meritas;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

/**
 * Created by Bharat Kumar on 27-Sep-16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<StudentAccounts> {

    public CustomAdapter(Context context, ArrayList<StudentAccounts> accounts) {
        super(context, 0, accounts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.student_list, parent, false);
        }

        StudentAccounts account = getItem(position);
        int i=position+1;

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.nameText);
        nameTextView.setText(String.valueOf(i)+".Name of student : "+account.get_studentname());

        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phoneText);
        phoneTextView.setText("PhoneNo : "+account.get_phone());

        TextView emailTextView = (TextView) listItemView.findViewById(R.id.emailText);
        emailTextView.setText("Email_id : "+account.get_email());

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.addressText);
        addressTextView.setText("Address : "+account.get_address());

        TextView courseTextView = (TextView) listItemView.findViewById(R.id.courseText);
        courseTextView.setText("Course : "+account.get_course());

        return listItemView;
    }
}