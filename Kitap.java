package kütüphane;

// kütüphane.Kitap sınıfı: sadece veri tutar
public class Kitap {
    private String ad;
    private int sayfaSayisi;
    private String yazarAdi;
    public boolean oduncAlındımı= false;

    public Kitap(int sayfaSayisi, String ad, String yazarAdi) {
        this.sayfaSayisi = sayfaSayisi;
        this.ad = ad;
        this.yazarAdi = yazarAdi;
    }
    public String getAd() {
        return ad;
    }
    public int getSayfaSayisi() {
        return sayfaSayisi;
    }
    public String getYazarAdi() {
        return yazarAdi;
    }
    public boolean getOdunc(){
        return oduncAlındımı;
    }

    public String toString() {
        return "Kitap: " + ad + ", Sayfa: " + sayfaSayisi + ", Yazar: " + yazarAdi+",Ödünç Alindi mi?"+(oduncAlındımı ? "Evet":"Hayir");
    }
}
