package com.example.alsverisuygulamas;

public class Urun {
    private int urunResim;
    private String urunAdı,urunFiyat;


    public int getUrunResim() {
        return urunResim;
    }

    public void setUrunResim(int urunResim) {
        this.urunResim = urunResim;
    }

    public String getUrunAdı() {
        return urunAdı;
    }

    public void setUrunAdı(String urunAdı) {
        this.urunAdı = urunAdı;
    }

    public String getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(String urunFiyat) {
        this.urunFiyat = urunFiyat;
    }


    public Urun(int urunResim, String urunadı, String urunFiyat){
        this.urunAdı=urunadı;
        this.urunResim=urunResim;
        this.urunFiyat=urunFiyat;

    }


}
