package arayuz;

import hatalar.KullaniciBulunamadiException;
import hatalar.SifreEslesmiyorException;
import hatalar.YanlisSifreException;
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
            String ePosta, sifre;
            boolean sifreDogru;

            System.out.print("Giriş yapma seçeneği seçtiniz.");
            System.out.println();

            System.out.print("E-postanız: ");
            ePosta = scanner.nextLine();

            System.out.print("Şifreniz: ");
            sifre = scanner.nextLine();

            Kullanici kullanici = null;

            try {
                kullanici = Veritabani.getKullanici(ePosta);
                sifreDogru = kullanici.sifre(sifre);

                if (sifreDogru) {
                    System.out.println(kullanici.getAdSoyad() + " (" + kullanici.getKullaniciAdi() + "), tekrardan hoşgeldiniz!");
                    return kullanici.getKullaniciNumarasi();
                }

                System.out.println("Kullanıcı adınızı veya şifrenizi yanlış girdiniz, lütfen yeniden deneyiniz.");
                return -1;
            } catch (KullaniciBulunamadiException e) {
                System.out.println("Kullanıcı adınızı veya şifrenizi yanlış girdiniz, lütfen yeniden deneyiniz.");
                return -1;
            }
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

            while (true) {
                System.out.print("Seçiminiz: ");
                int secim = this.scanner.nextInt();

                if (secim > 6 || secim < 1) {
                    System.out.println("Geçersiz bir giriş yaptınız, lütfen yeniden deneyiniz.");
                } else {
                    return secim;
                }
            }
        }

        private void profilListesi() {
            int sonKullaniciId = -1;

            System.out.println("Profil seçmek için profille eşleşen numarayı yazın. Geri dönmek için -1 yazın.");
            System.out.println();

            for (Kullanici kullanici: Veritabani.getKullanici()) {
                System.out.println("["
                        + kullanici.getKullaniciNumarasi()
                        + "] "
                        + kullanici.getAdSoyad() +
                        " (" +
                        kullanici.getKullaniciAdi() +
                        ")"
                );

                sonKullaniciId++;
            }

            while (true) {
                System.out.print("Seçiminiz: ");
                int secim = this.scanner.nextInt();

                if (secim == -1) {
                   return;
                } else if (secim > sonKullaniciId) {
                    System.out.println("Lütfen seçimizini kontrol edip yeniden deneyiniz.");
                } else {
                    profilSayfasi(secim);
                    return;
                }
            }
        }

        private void profilSayfasi(int kullaniciNumarasi) {

        }

        private void sifreDegistir() {
            String eskiSifre, yeniSifre, yeniSifreTekrardan;

            System.out.print("Eski şifreniz: ");
            eskiSifre = this.scanner.nextLine();
            System.out.print("Yeni şifreniz: ");
            yeniSifre = this.scanner.nextLine();
            System.out.print("Yeni şifreniz (tekrardan): ");
            yeniSifreTekrardan = this.scanner.nextLine();

            try {
                kullanici.sifre(eskiSifre, yeniSifre, yeniSifreTekrardan);
            } catch (YanlisSifreException e) {
                System.out.println("Eski şifrenizi yanlış girdiniz. Lütfen kontrol edip yeniden deneyiniz.");
            } catch (SifreEslesmiyorException e) {
                System.out.println("Girdiğiniz şifreler birbiriyle uyuşmuyor. Lütfen kontrol edip yeniden deneyiniz.");
            }
        }
    }
}
