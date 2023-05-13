package com.example.alsverisuygulamas;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyRecycAdaptor extends RecyclerView.Adapter<MyRecycAdaptor.Myholder> {
    private ArrayList<Urun> urunler;

    public MyRecycAdaptor(ArrayList<Urun> urunler) {
        this.urunler=urunler;
    }


    @NonNull
    @Override

    // ınflater ile şişirik holder ile tuttuk
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.urun_item,parent,false) ;
        return new Myholder(view);
    }


    //sayfanın içeriğini de bununla yönlendiricez  bu metodların içleri dolu olması gerekir
    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.txturunFiyatı.setText(urunler.get(position).getUrunFiyat());
        holder.txturunAdı.setText(urunler.get(position).getUrunAdı());
        holder.imgResim.setImageResource(urunler.get(position).getUrunResim());
    }


    // gorunmesi için
    @Override
    public int getItemCount() {
        return urunler.size();
    }

    public  class Myholder extends  RecyclerView.ViewHolder{
        TextView txturunAdı,txturunFiyatı;
        ImageView imgResim;

        public Myholder(@NonNull View itemView) {

            super(itemView);
            imgResim=itemView.findViewById(R.id.img_urunResim);
            txturunAdı= itemView.findViewById(R.id.txt_urunAdı);
            txturunFiyatı= itemView.findViewById(R.id.txt_urunFiyatı);
        }
    }
}
