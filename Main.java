package kütüphane;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Yönetim sınıflarından obje oluştur
        KisiYonetim kisiYonetim = new KisiYonetim();
        KitapYonetim kitapYonetim = new KitapYonetim();

        System.out.println("------Mr.Dexmatt Kütüphanesine Hoşgeldiniz!!!------");

        boolean devam = true;
        while (devam) {
            System.out.println("\n1-Kişi Ekle");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kişileri Listele");
            System.out.println("4-Kitapları Listele");
            System.out.println("5-Kitap Ödünç Al");
            System.out.println("6-Kitap Teslim Et");
            System.out.println("7-Çıkış");
            System.out.print("Yapacağınız işlemi seçiniz: ");

            int op = input.nextInt();
            input.nextLine(); // Dummy input

            switch (op) {
                case 1:
                    kisiYonetim.kisiEkle();
                    break;
                case 2:
                    kitapYonetim.kitapEkle();
                    break;
                case 3:
                    // Kişileri listeleme metodu yok ama yapabilirsin:
                    if (kisiYonetim.kisiler.isEmpty()) {
                        System.out.println("Kayıtlı kişi yok.");
                    } else {
                        for (Kişi kisi : kisiYonetim.kisiler) {
                            System.out.println(kisi.bilgileriGetir());
                        }
                    }
                    break;
                case 4:
                    kitapYonetim.kitaplariListele();
                    break;
                case 5:
                    kitapYonetim.kitapOduncAl(kisiYonetim);
                    break;
                case 6:
                    kitapYonetim.KitapTeslimEt(kisiYonetim);
                    break;
                case 7:
                    devam = false;
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }

        input.close();
    }
}
