package com.example.alsverisuygulamas;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {



    BottomNavigationView BottomNavi;
    TextView textBottomNaviGoruntu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //kullanıcı adi gösterme

        BottomNavi = findViewById(R.id.bnavi);
        //ilk home gelcek
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeF()).commit();
        BottomNavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new SearchF()).commit();
                        break;

                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeF()).commit();
                        break;

                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new PersonF()).commit();
                        break;



                }

                return true;
            }
        });





    }}