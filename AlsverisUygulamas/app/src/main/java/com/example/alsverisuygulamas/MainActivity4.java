package com.example.alsverisuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    DbHelper dbHelper;
    EditText showtxt;


    //kullanıcıları tabloda gösterme
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        dbHelper = new DbHelper(this);
        showtxt = findViewById(R.id.showtxt);
        showtxt.setText("");

        Cursor c = dbHelper.getReadableDatabase().query(DbHelper.TABLE_NAME, null, null, null, null, null, null);

        int IdIndex=c.getColumnIndex("id");
        int NameIndex=c.getColumnIndex("name");
        int SurnameIndex=c.getColumnIndex("surname");
        int NickIndex=c.getColumnIndex("nick");
        int EmailIndex=c.getColumnIndex("email");
        int PasswordIndex=c.getColumnIndex("password");

        while (c.moveToNext()){
            showtxt.append(
                    "Id:"+c.getInt(IdIndex) +
                    "Ad:"+c.getInt(NameIndex)+
                    "Soyad:"+c.getInt(SurnameIndex)+
                    "Kullncı Adı:"+c.getInt(NickIndex)+
                    "E-mail:"+c.getInt(EmailIndex)+
                    "Şifre:"+c.getInt(PasswordIndex)+"\n");


        }









    }


}
