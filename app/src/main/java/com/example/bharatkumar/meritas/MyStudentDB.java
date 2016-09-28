package com.example.bharatkumar.meritas;

/**
 * Created by Bharat Kumar on 27-Sep-16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyStudentDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    public static final String TABLE_ACCOUNTS="student_accounts";
    public static final String COLUMN_STUDENTNAME="studentname";
    public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_COURSE="course";


    public MyStudentDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String query="CREATE TABLE " +  TABLE_ACCOUNTS + "(" +
                COLUMN_STUDENTNAME + " TEXT PRIMARY KEY, "+
                COLUMN_ADDRESS + " TEXT, "+
                COLUMN_PHONE + " TEXT, "+
                COLUMN_EMAIL + " TEXT, "+
                COLUMN_COURSE + " TEXT "+
                ");";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ACCOUNTS);
        onCreate(sqLiteDatabase);
    }

    public boolean addAccount(StudentAccounts accounts)
    {
        boolean dbAccepter=true;
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENTNAME, accounts.get_studentname());
        values.put(COLUMN_ADDRESS, accounts.get_address());
        values.put(COLUMN_PHONE, accounts.get_phone());
        values.put(COLUMN_EMAIL, accounts.get_email());
        values.put(COLUMN_COURSE, accounts.get_course());

        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insertOrThrow(TABLE_ACCOUNTS, null, values);
            db.close();
        }
        catch (SQLiteConstraintException e)
        {
            dbAccepter=false;
            System.out.println(e);

        }
        return dbAccepter;


    }

    public  void  deleteAccount(String userName)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_ACCOUNTS +" WHERE "+ COLUMN_STUDENTNAME + "=\"" + userName + "\";");
    }



    public ArrayList<StudentAccounts> allData()
    {
        ArrayList<StudentAccounts> accounts= new ArrayList<StudentAccounts>();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_ACCOUNTS +" WHERE 1";

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("studentname"))!=null)
            {

                accounts.add(new StudentAccounts(c.getString(c.getColumnIndex("studentname")),
                                                 c.getString(c.getColumnIndex("phone")),
                                                 c.getString(c.getColumnIndex("email")),
                                                 c.getString(c.getColumnIndex("address")),
                                                 c.getString(c.getColumnIndex("course"))));


            }
            c.moveToNext();
        }
        db.close();
        return accounts;
    }



    public StudentAccounts findData(String uname)
    {
        StudentAccounts accounts= new StudentAccounts();
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_ACCOUNTS +" WHERE studentname=" + "'"+uname+"'";

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

            if(c.getString(c.getColumnIndex("studentname"))!=null)
            {

                accounts.set_studentname(c.getString(c.getColumnIndex("studentname")));
                accounts.set_phone(c.getString(c.getColumnIndex("phone")));
                accounts.set_email(c.getString(c.getColumnIndex("email")));
                accounts.set_address(c.getString(c.getColumnIndex("address")));
                accounts.set_course(c.getString(c.getColumnIndex("course")));


            }
        db.close();
        return accounts;
    }

    public boolean updateContact(String sname, String phno, String email,String address,String course)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_PHONE, phno);
        args.put(COLUMN_EMAIL, email);
        args.put(COLUMN_ADDRESS,address);
        args.put(COLUMN_COURSE,course);
        return db.update(TABLE_ACCOUNTS, args, COLUMN_STUDENTNAME + "=" +"'"+ sname+"'", null) > 0;
    }

}