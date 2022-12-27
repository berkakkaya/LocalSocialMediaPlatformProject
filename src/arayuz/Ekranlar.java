package arayuz;

import gonderi.Gonderi;
import gonderi.NormalGonderi;
import hatalar.KullaniciBulunamadiException;
import hatalar.SifreEslesmiyorException;
import hatalar.YanlisSifreException;
import kullanici.Kullanici;
import veritabani.Veritabani;

import java.util.ArrayList;
import java.util.Scanner;

public class Ekranlar {

    static public class AnaEkran {
        private final Scanner scanner;

        public AnaEkran() {
            scanner = new Scanner(System.in);
        }

        public void calistir() {
            System.out.println("Platforma hoşgeldiniz!");
            System.out.println("Lütfen üye girişi yapınız veya kayıt olunuz.");
            System.out.println();

            int kullaniciId;
            GirisSonrasi girisSonrasi;
            Kullanici kullanici;

            while (true) {
                int secim = menuYazdir();

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
                        return;
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
                        return;
                    }
                } else { // Uygulamadan çık
                    this.cikisYap();
                    return;
                }
            }
        }

        private void cikisYap() {
            scanner.close();
            System.exit(0);
        }

        private int girisYap() {
            String ePosta, sifre;
            boolean sifreDogru;

            System.out.println("Giriş yapma seçeneği seçtiniz.");
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
            kullaniciAdi = "@" + kullaniciAdi;
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

            if (kullaniciBulundu) {
                System.out.println("Platformda aynı e-postaya sahip bir kullanıcı var. Lütfen e-postanızı kontrol edip yeniden deneyiniz.");
                return -1;
            }
            try {
                Kullanici kullanici = new Kullanici(adSoyad, ePosta, kullaniciAdi, sifre, sifreYeniden);
                Veritabani.addKullanici(kullanici);
                System.out.println("Başarıyla kayıt olma işlemi tamamlandı!");
                System.out.println(kullanici.getAdSoyad() + " (" + kullanici.getKullaniciAdi() + "), platformumuza hoşgeldiniz!");
                return kullanici.getKullaniciNumarasi();
            } catch (SifreEslesmiyorException e) {
                System.out.println("Yazdığınız şifreler eşleşmiyor. Lütfen şifrenizi kontrol edip yeniden deneyiniz.");
                return -1;
            }
        }

        private int menuYazdir() {
            int secim;

            System.out.println("Platforma hoşgeldiniz!");
            System.out.println("Lütfen üye girişi yapınız veya kayıt olunuz.");
            System.out.println();
            System.out.println("[1] Giriş Yap");
            System.out.println("[2] Kayıt Ol");
            System.out.println("[3] Uygulamadan Çık");
            System.out.println();

            while (true) {
                System.out.print("Seçiminiz: ");
                secim = this.scanner.nextInt();
                this.scanner.nextLine(); // sonrasında string alırken sorun çıkarmaması için

                if (secim < 1 || secim > 3) {
                    System.out.println("Geçersiz giriş yaptınız, lütfen yeniden deneyiniz.");
                } else {
                    return secim;
                }
            }
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
            while (true) {
                int menuSecim = menuYazdir();
                switch (menuSecim) {
                    case 1 -> profilListesi();
                    case 2 -> profilSayfasi(-1);
                    case 3 -> gonderiPaylas();
                    case 4 -> kullaniciBilgileriniDegistir();
                    case 5 -> sifreDegistir();
                    case 6 -> {
                        cikisYap();
                        return;
                    }
                }
            }
        }

        private void cikisYap() {
            scanner.close();
            System.exit(0);
        }

        private void gonderiPaylas() {
            String icerik, gondermeOnayi;
            NormalGonderi gonderi;

            System.out.println("Yeni gönderi paylaşacaksınız.");
            System.out.println();
            System.out.println("Lütfen yazmak istediğiniz şeyi yazın ve bitirince ENTER tuşuna basın.");
            System.out.println();

            icerik = this.scanner.nextLine();

            System.out.print("Gönderiyi paylaşmak istediğinize emin misiniz (e/h): ");
            gondermeOnayi = this.scanner.nextLine();

            if (gondermeOnayi.equals("e")) {
                gonderi = new NormalGonderi(this.kullanici, icerik);
                Veritabani.addGonderi(gonderi);

                System.out.println("Gönderi paylaşıldı.");
                return;
            }

            System.out.println("Gönderi paylaşılmadı.");
        }

        private void kullaniciBilgileriniDegistir() {
            System.out.println("Kullanıcı bilgileriniz şu şekilde:");
            System.out.println("- Ad ve soyadınız: " + kullanici.getAdSoyad());
            System.out.println("- E-posta adresiniz: " + kullanici.getEposta());
            System.out.println("- Kullanıcı adınız: @" + kullanici.getKullaniciAdi());
            System.out.println();
            System.out.println("Eskisini tutmak için boş bırakıp ENTER tuşuna basın.");
            System.out.println();

            System.out.print("Yeni ad ve soyadınız (" + kullanici.getAdSoyad() + "): ");
            String yeniAdSoyad = scanner.nextLine();
            System.out.println();

            System.out.print("Yeni e-posta adresiniz (" + kullanici.getEposta() + "): ");
            String yeniEposta = scanner.nextLine();
            System.out.println();

            System.out.println("Yeni bilgileriniz şu şekilde olacak:");

            System.out.println("- Ad ve soyadınız: " + (yeniAdSoyad.length() == 0 ? kullanici.getAdSoyad() : yeniAdSoyad));
            System.out.println("- E-posta adresiniz: " + (yeniEposta.length() == 0 ? kullanici.getEposta() : yeniEposta));
            System.out.println("- Kullanıcı adınız: @" + kullanici.getKullaniciAdi());

            boolean bilgiDegistirmeGecersizGiris = true;

            while (bilgiDegistirmeGecersizGiris) {
                bilgiDegistirmeGecersizGiris = false;
                System.out.println();
                System.out.print("Onaylıyor musunuz? (e/h): ");
                String bilgiDegistirmeOnaylama = scanner.nextLine();

                if (bilgiDegistirmeOnaylama.equals("e") || bilgiDegistirmeOnaylama.equals("E")) {
                    if (yeniAdSoyad.length() != 0) {
                        kullanici.setAdSoyad(yeniAdSoyad);
                    }

                    if (yeniEposta.length() != 0) {
                        kullanici.setEposta(yeniEposta);
                    }

                    System.out.println("Yeni bilgileriniz kaydedildi.");
                } else if (bilgiDegistirmeOnaylama.equals("h") || bilgiDegistirmeOnaylama.equals("H")) {
                    System.out.println("Bilgiler kaydedilmedi.");
                } else {
                    System.out.println("Geçersiz giriş yapıldı, lütfen yeniden deneyiniz.");
                    bilgiDegistirmeGecersizGiris = true;
                }
            }
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
                int menuSecim = scanner.nextInt();
                this.scanner.nextLine(); // sonrasında string alırken sorun çıkarmaması için

                if (menuSecim < 1 || menuSecim > 6) {
                    System.out.println("Geçersiz giriş yaptınız, lütfen yeniden deneyiniz.");
                } else {
                    return menuSecim;
                }
            }
        }

        private void profilListesi() {
            int sonKullaniciId = -1;

            System.out.println("Profil seçmek için profille eşleşen numarayı yazın. Geri dönmek için -1 yazın.");
            System.out.println();

            for (Kullanici kullanici : Veritabani.getKullanici()) {
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
                this.scanner.nextLine(); // sonrasında string alırken sorun çıkarmaması için

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
            ArrayList<Gonderi> gonderiler;
            Gonderi anlikGonderi;

            if (kullaniciNumarasi == -1) {
                gonderiler = Veritabani.getGonderi(kullanici);
            } else {
                try {
                    Kullanici bulunanKullanici = Veritabani.getKullanici(kullaniciNumarasi);
                    gonderiler = Veritabani.getGonderi(bulunanKullanici);
                } catch (KullaniciBulunamadiException e) {
                    throw new RuntimeException(e);
                }
            }

            final int toplamGonderiSayisi = gonderiler.size();
            int suAnkiGonderiNumarasi = 1;

            while (true) {
                System.out.println(kullanici.getAdSoyad() + " (" + kullanici.getKullaniciAdi() + ")");
                System.out.println();

                System.out.println(toplamGonderiSayisi + " gönderiden " + suAnkiGonderiNumarasi + ". gönderi");
                System.out.println();

                anlikGonderi = gonderiler.get(suAnkiGonderiNumarasi - 1);

                anlikGonderi.yazdir();

                boolean oncekiGonderiButonuAktif, sonrakiGonderiButonuAktif;

                if (suAnkiGonderiNumarasi != 1) {
                    System.out.println("Önceki gönderi: [j]");
                    oncekiGonderiButonuAktif = true;
                } else {
                    oncekiGonderiButonuAktif = false;
                }

                if (suAnkiGonderiNumarasi != toplamGonderiSayisi) {
                    System.out.println("Sonraki gönderi: [k]");
                    sonrakiGonderiButonuAktif = true;
                } else {
                    sonrakiGonderiButonuAktif = false;
                }

                if (!anlikGonderi.checkBegen(this.kullanici)) {
                    System.out.println("Gönderiyi beğen: [e]");
                } else {
                    System.out.println("Gönderiyi beğenmekten vazgeç: [e]");
                }

                System.out.println("Gönderiyi yeniden paylaş: [r]");
                System.out.println("Profil görünümünden çık: [q]");

                System.out.print("İlgili harfi tuşlayıp [ENTER] tuşuna basınız: ");
                String secim = scanner.nextLine();

                /*
                 * Önceki gönderi: [j]
                 * Sonraki gönderi: [k]
                 * Gönderiyi beğen: [e]
                 * Gönderiyi yeniden paylaş: [r]
                 * Profil görünümünden çık: [q]
                 * */

                if (secim.equals("q")) {
                    return;
                }

                if (secim.equals("r")) {
                    anlikGonderi.yenidenPaylas(kullanici);
                }

                if (secim.equals("e")) {
                    anlikGonderi.begen(kullanici);
                }

                if (sonrakiGonderiButonuAktif && secim.equals("k")) {
                    suAnkiGonderiNumarasi++;
                }

                if (oncekiGonderiButonuAktif && secim.equals("j")) {
                    suAnkiGonderiNumarasi--;
                }
            }
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
