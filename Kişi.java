package kütüphane;

public class Kişi {
    public String ad;
    public boolean ödüncAlmışmı = false;
    public String alınanKitap;

    public Kişi(String ad) {
        this.ad = ad;
    }

    public String bilgileriGetir() {
        return "Ad: " + ad + (ödüncAlmışmı ? ", Ödünç aldığı kitap: " + alınanKitap : ", Ödünç alınan kitap yok");
    }

    public void kitapOduncAl(String kitapAd) {
        this.alınanKitap = kitapAd;
        this.ödüncAlmışmı = true;
    }

    public void kitapTeslimEt() {
        this.alınanKitap = null;
        this.ödüncAlmışmı = false;
    }
}
