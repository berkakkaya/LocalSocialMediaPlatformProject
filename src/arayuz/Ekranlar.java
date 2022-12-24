package arayuz;

import kullanici.Kullanici;

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

        }

        private int girisYap() {
            // TODO: Başlarken buradaki kodu silin.
            return 0;
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

        }

        private void kullaniciBilgileriniDegistir() {

        }

        private int menuYazdir() {
            // TODO: Başlarken buradaki kodu silin.
            return 0;
        }

        private void profilListesi() {

        }

        private void profilSayfasi(int kullaniciNumarasi) {

        }

        private void sifreDegistir() {

        }
    }
}
