package com.example.alsverisuygulamas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {


    EditText txtName, txtSurname, txtNick, txtPassword, txtEmail;
    Button btnkayıtol2,btnGoster;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        DbHelper dbHelper = new DbHelper(this);


        txtName = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtPassword);
        txtSurname = findViewById(R.id.txtSurname);
        txtEmail = findViewById(R.id.txtEmail);
        txtNick = findViewById(R.id.txtNick);


        //butona basında db de kayıtlı kişiler görünüyor
        btnGoster=findViewById(R.id.btn_Goster);
        btnGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intent);

            }
        });


        //yeni kullnıcı ekleme
        btnkayıtol2 = findViewById(R.id.btn_kayıtol2);
        btnkayıtol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String surname = txtSurname.getText().toString();
                String nick = txtNick.getText().toString();
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                boolean result = dbHelper.insertData(name, surname, nick, email, password);

                if (!result) {
                    Toast.makeText(MainActivity3.this, "Kayıt oluşturulamadı", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity3.this, "Kayıt başarıyla oluşturuldu", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
