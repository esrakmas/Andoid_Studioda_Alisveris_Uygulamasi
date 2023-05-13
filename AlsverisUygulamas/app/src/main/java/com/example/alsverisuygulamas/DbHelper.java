package com.example.alsverisuygulamas;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db";

    public static final String TABLE_NAME = "person";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String NICK = "nick";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " TEXT,"
                + SURNAME + " TEXT,"
                + NICK + " TEXT,"
                + EMAIL + " TEXT,"
                + PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //yeni kullanıcı oluşturma
    public boolean insertData(String name, String surname, String nick, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SURNAME, surname);
        contentValues.put(NICK, nick);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }


}
