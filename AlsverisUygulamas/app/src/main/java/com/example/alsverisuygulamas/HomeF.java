package com.example.alsverisuygulamas;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeF extends Fragment {

    private RecyclerView benimrecyler;
    private ArrayList<Urun> urunler;
    private MyRecycAdaptor myadaptor;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);


        benimrecyler=(RecyclerView)view.findViewById(R.id.myrecyc);
        urunler=new ArrayList<>();

        //Urunlerle bana bir adaptor olurtur
        myadaptor=new MyRecycAdaptor(urunler);

        benimrecyler.setAdapter(myadaptor);

        //şişirdiğimiz görüntülerin burda yukardan aşağı göürnmesini istiyorum bu set işlemiyle yapcaz
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        benimrecyler.setLayoutManager(layoutManager);
        
        diziolurur();
        

        //herhangi bir değişiklik olduğunda değiştirsin
        myadaptor.notifyDataSetChanged();
        

   


        return view;
    }

    private void diziolurur() {
        urunler.add(new Urun(R.drawable.shirt1,"Yeşil Tişört","10 ₺"));
        urunler.add(new Urun(R.drawable.shirt2,"Mavi Tişört","120 ₺"));
        urunler.add(new Urun(R.drawable.shirt3,"Mavi Gömlek","10 ₺"));
        urunler.add(new Urun(R.drawable.blouse,"Bluz","50 ₺"));
        urunler.add(new Urun(R.drawable.dress1,"Sarı Elbise","10 ₺"));
        urunler.add(new Urun(R.drawable.dress2,"Turuncu Elbise","120 ₺"));
    }


}