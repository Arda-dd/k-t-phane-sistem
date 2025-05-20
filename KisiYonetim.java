package kütüphane;

import java.util.*;

public class KisiYonetim {
    public ArrayList<Kişi> kisiler = new ArrayList<>();
    public Scanner input = new Scanner(System.in);


    public void kisiEkle(){
        System.out.println("Ad Soyad:");
        String ad = input.nextLine();

        Kişi yeniKisi=new Kişi(ad);
        kisiler.add(yeniKisi);

    }


}
