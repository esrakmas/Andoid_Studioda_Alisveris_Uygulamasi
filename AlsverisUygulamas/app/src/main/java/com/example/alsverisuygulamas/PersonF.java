package com.example.alsverisuygulamas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PersonF#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonF extends Fragment  {
    TextView showtxt;
    EditText txtNameGuncel,txtSurnameGuncel,txtEmailGuncel,txtNickGuncel,txtPasswordGuncel;
    Button btn_guncelle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_person, container, false);

        showtxt=view.findViewById(R.id.showtxt);
        txtNameGuncel=view.findViewById(R.id.txtNameGuncel);
        txtSurnameGuncel=view.findViewById(R.id.txtSurnameGuncel);
        txtEmailGuncel=view.findViewById(R.id.txtEmailGuncel);
        txtPasswordGuncel=view.findViewById(R.id.txtPasswordGuncel);
        btn_guncelle=view.findViewById(R.id.btn_guncelle);

        return view;
    }
}