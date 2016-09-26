package com.example.bharatkumar.meritas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Bharat Kumar on 25-Sep-16.
 */
public class MyRegistrationDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="accountDB.db";
    public static final String TABLE_ACCOUNTS="accounts";
    public static final String COLUMN_FIRSTNAME="firstname";
    public static final String COLUMN_LASTNAME="lastname";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_USERPASSWORD="userpassword";

    public MyRegistrationDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="CREATE TABLE " +  TABLE_ACCOUNTS + "(" +
                COLUMN_FIRSTNAME + " TEXT, "+
                COLUMN_LASTNAME + " TEXT, "+
                COLUMN_PHONE + " TEXT, "+
                COLUMN_EMAIL + " TEXT, "+
                COLUMN_USERNAME + " TEXT PRIMARY KEY, "+
                COLUMN_USERPASSWORD + " TEXT "+
                ");";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_ACCOUNTS);
        onCreate(sqLiteDatabase);
    }

    public boolean addAccount(RegisteredAccounts accounts)
    {
        boolean dbAccepter=true;
            ContentValues values = new ContentValues();
            values.put(COLUMN_FIRSTNAME, accounts.get_firstname());
            values.put(COLUMN_LASTNAME, accounts.get_lastname());
            values.put(COLUMN_PHONE, accounts.get_phone());
            values.put(COLUMN_EMAIL, accounts.get_email());
            values.put(COLUMN_USERNAME, accounts.get_username());
            values.put(COLUMN_USERPASSWORD, accounts.get_password());
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.insert(TABLE_ACCOUNTS, null, values);
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
        db.execSQL("DELETE FROM "+ TABLE_ACCOUNTS +" WHERE "+ COLUMN_USERNAME + "=\"" + userName + "\";");
    }

    public String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_ACCOUNTS +" WHERE 1";

        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("username"))!=null)
            {

                dbString += c.getString(c.getColumnIndex("username"))+" "+c.getString(c.getColumnIndex("userpassword"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}
