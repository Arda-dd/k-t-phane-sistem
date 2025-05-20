package kütüphane;

import java.util.*;

public class KitapYonetim {
    private ArrayList<Kitap> kitaplar = new ArrayList<>();
    private int kitapSayisi = 0;
    private Scanner input = new Scanner(System.in);

    public void kitapEkle() {
        System.out.print("Kitap adını giriniz: ");
        String ad = input.nextLine();

        System.out.print("Sayfa sayısını giriniz: ");
        int sayfa = input.nextInt();
        input.nextLine(); // Dummy input

        System.out.print("Yazar adını giriniz: ");
        String yazar = input.nextLine();

        Kitap yeniKitap = new Kitap(sayfa, ad, yazar);
        kitaplar.add(yeniKitap);
        System.out.println("Kitap eklendi!\n");
        kitapSayisi++;

    }

    public void kitapOduncAl(KisiYonetim kisiYonetim) {
        if (kitapSayisi > 0) {
            kitaplariListele();

            System.out.println("Ödünç almak istediğiniz kitabın adını giriniz");
            String kitapAdi = input.nextLine();

            Kitap secilenKitap = null;
            for (Kitap kitap : kitaplar) {
                if (kitap.getAd().equalsIgnoreCase(kitapAdi)) {
                    secilenKitap = kitap;
                    break;
                }
            }

            if (secilenKitap == null) {
                System.out.println("Aradığınız kitap bulunamadı!");
                return;
            }

            if (secilenKitap.oduncAlındımı) {
                System.out.println("Ödünç alınmış kitabı ödünç alamazsınız!!!");
                return;
            }

            System.out.println("Kitabı almak isteyen kişinin adını giriniz:");
            String kisiAdi = input.nextLine();

            Kişi secilenKisi = null;
            for (Kişi kisi : kisiYonetim.kisiler) {
                if (kisi.ad.equalsIgnoreCase(kisiAdi)) {
                    secilenKisi = kisi;
                    break;
                }
            }

            if (secilenKisi == null) {
                System.out.println("Kişi bulunamadı!");
                return;
            }
            if (secilenKisi.ödüncAlmışmı){
                System.out.println("Bir kişi birden fazla kitap ödünç alamaz!!!");
            }else{



            // İlişkiyi kur
            secilenKitap.oduncAlındımı = true;
            secilenKisi.kitapOduncAl(secilenKitap.getAd());
            kitapSayisi--;

            System.out.println("Kitap ödünç alındı!");
            }
        } else {
            System.out.println("Kütüphanede kitap yok");
        }
    }


    public void KitapTeslimEt(KisiYonetim kisiYonetim) {
        System.out.println("Teslim etmek istediğiniz kitabın adını giriniz");
        String teslimKitap = input.nextLine();
        Kitap secilenKitap = null;
        for (Kitap kitap : kitaplar) {
            if (kitap.getAd().equalsIgnoreCase(teslimKitap)) {
                secilenKitap = kitap;
                break;
            }
        }
        System.out.println("Kitabı teslim etmek isteyen kişnin adını giriniz:");
        String kisiAdi = input.nextLine();

        Kişi secilenKisi = null;
        for (Kişi kisi : kisiYonetim.kisiler) {
            if (kisi.ad.equalsIgnoreCase(kisiAdi)) {
                secilenKisi = kisi;
                break;
            }
        }
        if (secilenKisi == null) {
            System.out.println("Kişi bulunamadı");
            return;
        } else {
            if (secilenKitap.oduncAlındımı) {
                secilenKitap.oduncAlındımı = false;
                kitapSayisi++;
                secilenKisi.kitapTeslimEt();

            }


        }
    }
        public void kitaplariListele () {
            if (kitaplar.isEmpty()) {
                System.out.println("Hiç kitap eklenmemiş.");

            }

            for (Kitap k : kitaplar) {
                System.out.println(k);
            }
        }

}
