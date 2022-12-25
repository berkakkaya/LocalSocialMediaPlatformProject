package arayuz;

import hatalar.KullaniciBulunamadiException;
import hatalar.SifreEslesmiyorException;
import kullanici.Kullanici;

import veritabani.Veritabani;

import java.util.Scanner;

public class Ekranlar {
    static public class AnaEkran {
        private final Scanner scanner;

        public AnaEkran() {
            scanner = new Scanner(System.in);
        }

        public void calistir() {

        }

        private void cikisYap() {
                System.out.println("Çıkış yapılıyor.");
                scanner.close();
                System.exit(0);

        }

        private int girisYap() {
            // TODO: Başlarken buradaki kodu silin.
            return 0;
        }

        private int kayitOl() {
            System.out.println("Kayıt olma seçeneğini seçtiniz.");
            System.out.println();
            System.out.print("Adınız ve soyadınız: ");
            String adSoyad = scanner.nextLine();
            System.out.print("E-posta adresiniz: ");
            String ePosta = scanner.nextLine();
            System.out.println();
            System.out.println("Kendinize bir kullanıcı adı seçiniz. Bu ad seçildikten sonra bir daha değiştirilemez.");
            System.out.print("Kullanıcı adınız: @");
            String kullaniciAdi = scanner.nextLine();
            System.out.println();
            System.out.print("Şifreniz: ");
            String sifre = scanner.nextLine();
            System.out.print("Şifreniz (tekrardan): ");
            String sifreYeniden = scanner.nextLine();

            boolean kullaniciBulundu;
            try {
                Veritabani.getKullanici(ePosta);
                kullaniciBulundu = true;
            } catch (KullaniciBulunamadiException e) {
                kullaniciBulundu = false;
            }

            if (kullaniciBulundu == true){
                System.out.println("Platformda aynı e-postaya sahip bir kullanıcı var. Lütfen e-postanızı kontrol edip yeniden deneyiniz.");
                return -1;
            }
            try {
                Kullanici kullanici = new Kullanici(adSoyad, ePosta, kullaniciAdi, sifre, sifreYeniden);
                Veritabani.addKullanici(kullanici);
                System.out.println("Başarıyla kayıt olma işlemi tamamlandı!");
                System.out.println(kullanici.getAdSoyad() + " (" + kullanici.getKullaniciAdi() + "), platformumuza hoşgeldiniz!" );
                return kullanici.getKullaniciNumarasi();
            } catch (SifreEslesmiyorException e) {
                System.out.println("Yazdığınız şifreler eşleşmiyor. Lütfen şifrenizi kontrol edip yeniden deneyiniz.");
                return -1;
            }
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
            System.out.print("Seçiminiz: ");
            int menuSecim = scanner.nextInt();
            return menuSecim;
        }

        private void profilListesi() {

        }

        private void profilSayfasi(int kullaniciNumarasi) {

        }

        private void sifreDegistir() {

        }
    }
}
