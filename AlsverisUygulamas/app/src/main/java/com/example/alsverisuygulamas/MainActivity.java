package com.example.alsverisuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btngiris,btnkayıtol;
    EditText Password,Email,Nick;
    SQLiteDatabase db;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Nick=findViewById(R.id.editTextNick);
       Email=findViewById(R.id.editTextEmail);
       Password=findViewById(R.id.editTextPassword);



       btnkayıtol=findViewById(R.id.btn_kayıtol);
       btnkayıtol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
       });

        dbHelper = new DbHelper(this);
        db = dbHelper.getReadableDatabase();

       btngiris=findViewById(R.id.btn_giris);
       btngiris.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String nick=Nick.getText().toString();
               String email = Email.getText().toString();
               String password = Password.getText().toString();


               String[] columns = {DbHelper.ID};
               String selection = DbHelper.NICK + " = ? AND " +DbHelper.EMAIL + " = ? AND " + DbHelper.PASSWORD + " = ?";
               String[] selectionArgs = {nick,email, password};

               Cursor cursor = db.query(DbHelper.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
               if (cursor != null && cursor.getCount() > 0) {
                   cursor.moveToFirst();
                   int idIndex = cursor.getColumnIndex(DbHelper.ID);
                   int userId = cursor.getInt(idIndex);
                   cursor.close();

                   Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                   intent.putExtra("userId", userId);
                   startActivity(intent);
                   finish();
                       Toast.makeText(MainActivity.this, "Başarıyla giriş yapıldı.", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "Kullanıcı Adı ,E-posta veya şifre hatalı", Toast.LENGTH_SHORT).show();
               }


           }
       });
    }

}