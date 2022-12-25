package arayuz;

import hatalar.KullaniciBulunamadiException;
import kullanici.Kullanici;
import veritabani.Veritabani;

import java.util.Scanner;

public class Ekranlar {

    static public class AnaEkran {
        private final Scanner scanner;

        public AnaEkran() {
            scanner = new Scanner(System.in);
        }

        public void calistir() {   //giriş yapma, kayıt olma olayları ele alacak
            boolean cikisYap = false;
            int secim = menuYazdir();
            int kullaniciId;
            GirisSonrasi girisSonrasi;
            Kullanici kullanici;

            do {
                if (secim == 1) { // Giriş yap
                    kullaniciId = girisYap();
                    if (kullaniciId != -1) {
                        try {
                            kullanici = Veritabani.getKullanici(kullaniciId);
                        } catch (KullaniciBulunamadiException e) {
                            throw new RuntimeException(e);
                        }

                        girisSonrasi = new GirisSonrasi(kullanici);
                        girisSonrasi.calistir();
                    }
                } else if (secim == 2) { // Kayıt ol
                    kullaniciId = kayitOl();
                    if (kullaniciId != -1) {
                        try {
                            kullanici = Veritabani.getKullanici(kullaniciId);
                        } catch (KullaniciBulunamadiException e) {
                            throw new RuntimeException(e);
                        }

                        girisSonrasi = new GirisSonrasi(kullanici);
                        girisSonrasi.calistir();
                    }
                } else if (secim == 3) { // Uygulamadan çık
                    cikisYap = true;
                } else {
                    System.out.println("Lütfen seçeneklerdeki rakamlardan birini girin.");
                }
            } while (cikisYap);

            this.cikisYap();
        }

        private void cikisYap() {

        }

        private int girisYap() {
            System.out.println();
            System.out.print("Giriş yapma seçeneği seçtiniz.");
            System.out.println();
            System.out.print("Giriş E-postanız: ");
            String eposta = scanner.next();//burda e-posta degiskeni yaratıp scanner ile atamamı yapacağım?
            System.out.print("Şifreniz: ");
            int sifre = scanner.nextInt();//burda sifre degiskeni yaratıp scanner ile atamamı yapacağım?
            Kullanici kullanici = Veritabani.getKullanici(eposta); // FIXME: try-catch kullan
            return kullanici.getKullaniciNumarasi();
            //devamını tam anlayamadım, Veritabanı ve hatalar sınıfına bağlı işlemler de görünüyor, onların bitmesi mi gerekli?

            return -1;
        }

        private int kayitOl() {
            // TODO: Başlarken buradaki kodu silin.
            return 0;
        }

        private int menuYazdir() {
            // TODO: Başlarken buradaki kodu silin.
            return 0;
        }
    }

    static public class GirisSonrasi {
        private final Kullanici kullanici;
        private final Scanner scanner;

        public GirisSonrasi(Kullanici kullanici) {
            this.kullanici = kullanici;
            this.scanner = new Scanner(System.in);
        }

        public void calistir() {

        }

        private void cikisYap() {
            this.scanner.close();
            System.exit(0);
        }

        private void kullaniciBilgileriniDegistir() {

        }

        private int menuYazdir() {
            System.out.println("[1] Kişilerin profiline göz at");
            System.out.println("[2] Kendi profiline göz at");
            System.out.println("[3] Yeni gönderi paylaş");
            System.out.println("[4] Kullanıcı bilgilerini değiştir");
            System.out.println("[5] Şifreyi değiştir");
            System.out.println("[6] Çıkış yap");
            System.out.println();
            System.out.print("Seçiminiz: "); //FIXME: Burada print kullanılması gerek-ok
            int secim = this.scanner.nextInt();
            return secim;
        }

        private void profilListesi() {
            System.out.println("Profil seçmek için profille eşleşen numarayı yazın. Geri dönmek için -1 yazın.");
            System.out.println();
            for (Kullanici kullanici : Veritabani.getKullanici()) {
                System.out.println(kullanici.getKullaniciNumarasi() + " - " + kullanici.getKullaniciAdi() + " - " + kullanici.getEposta());
            }
            System.out.print("Seçiminiz: ");
            int secim = this.scanner.nextInt();

            if (secim == -1) {
                profilListesi(); //FIXME: Buradaki sorunu düzelt
            } else {
                profilSayfasi(secim);
            }

        }

        private void profilSayfasi(int kullaniciNumarasi) {

        }

        private void sifreDegistir() {
            //FIXME: Fonksiyonun dokümantasyonunu tekrardan okuyarak burayı düzenle

            System.out.print("Eski şifreniz: ");
            String eskiSifre = this.scanner.next();
            System.out.print("Yeni şifreniz: ");
            String yeniSifre = this.scanner.next();
            System.out.print("Yeni şifreniz (tekrardan): ");
            String yeniSifreT = this.scanner.next();
            Kullanici kullanici = new Kullanici(); //FIXME: mevcut kullanıcının verilerini değiştir, yeni kullanıcı yaratma
            kullanici.sifre(eskiSifre, yeniSifre, yeniSifreT);
        }
    }
}
