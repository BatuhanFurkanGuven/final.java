package Sistem;
import java.util.ArrayList;
import java.util.Scanner;

class EmlakIlan {
    String ilanBasligi;
    String aciklama;
    double fiyat;
    String ilanTuru;

   
    public EmlakIlan(String ilanBasligi, String aciklama, double fiyat, String ilanTuru) {
        this.ilanBasligi = ilanBasligi;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.ilanTuru = ilanTuru;
    }

    public void yazdir() {
        System.out.println("İlan Başlığı: " + ilanBasligi);
        System.out.println("Açıklama: " + aciklama);
        System.out.println("Fiyat: " + fiyat + " TL");
        System.out.println("İlan Türü: " + ilanTuru);
        System.out.println("------------------------------");
    }
}

public class EmlakIlanSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmlakIlan> ilanlar = new ArrayList<>();
        boolean devam = true;

        while (devam) {
            System.out.println("\n=== Emlak İlan Sistemi ===");
            System.out.println("1. İlan Ekle");
            System.out.println("2. İlanları Listele");
            System.out.println("3. İlan Sil");
            System.out.println("4. Fiyat Aralığına Göre İlanları Listele");
            System.out.println("5. Çıkış");
            System.out.print("Bir seçenek girin: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); 

            switch (secim) {
                case 1:
                    
                    System.out.print("İlan Başlığı: ");
                    String baslik = scanner.nextLine();
                    System.out.print("Açıklama: ");
                    String aciklama = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double fiyat = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("İlan Türü (kiralık / satılık): ");
                    String ilanTuru = scanner.nextLine();

                    EmlakIlan ilan = new EmlakIlan(baslik, aciklama, fiyat, ilanTuru);
                    ilanlar.add(ilan);
                    System.out.println("İlan başarıyla eklendi!");
                    break;

                case 2:
                   
                    if (ilanlar.isEmpty()) {
                        System.out.println("Hiç ilan eklenmemiş.");
                    } else {
                        System.out.println("\n=== İlanlar ===");
                        for (EmlakIlan i : ilanlar) {
                            i.yazdir();
                        }
                    }
                    break;

                case 3:
                    
                    if (ilanlar.isEmpty()) {
                        System.out.println("Silinecek ilan yok.");
                    } else {
                        System.out.print("Silmek istediğiniz ilan başlığını girin: ");
                        String silinecekBaslik = scanner.nextLine();
                        boolean ilanBulundu = false;
                        for (int i = 0; i < ilanlar.size(); i++) {
                            if (ilanlar.get(i).ilanBasligi.equalsIgnoreCase(silinecekBaslik)) {
                                ilanlar.remove(i);
                                ilanBulundu = true;
                                System.out.println("İlan başarıyla silindi.");
                                break;
                            }
                        }
                        if (!ilanBulundu) {
                            System.out.println("Başlıkla eşleşen ilan bulunamadı.");
                        }
                    }
                    break;

                case 4:
                   
                    System.out.print("Minimum fiyatı girin: ");
                    double minFiyat = scanner.nextDouble();
                    System.out.print("Maksimum fiyatı girin: ");
                    double maxFiyat = scanner.nextDouble();

                    System.out.println("\n=== Fiyat Aralığındaki İlanlar ===");
                    boolean ilanBulundu = false;
                    for (EmlakIlan i : ilanlar) {
                        if (i.fiyat >= minFiyat && i.fiyat <= maxFiyat) {
                            i.yazdir();
                            ilanBulundu = true;
                        }
                    }
                    if (!ilanBulundu) {
                        System.out.println("Bu fiyat aralığında ilan bulunmamaktadır.");
                    }
                    break;

                case 5:
                   
                    System.out.println("Çıkılıyor...");
                    devam = false;
                    break;

                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
                    break;
            }
        }

       
    }
}
