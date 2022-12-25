package arayuz;

import kullanici.Kullanici;
<<<<<<< Updated upstream
=======
import veritabani.Veritabani;
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
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
=======
       private final Scanner scanner=new Scanner(System.in);

    public void calistir(){   //giriş yapma, kayıt olma olayları ele alacak
    int secim=menuYazdir();
    if(secim == 1){
        scanner.close();
        girisYap();
    } else if (secim==2) {
        kayitOl();
    } else if (secim==3) {
        scanner.close();
        cikisYap();
    }
    else {
        System.out.println("Lütfen seçeneklerdeki rakamlardan birini girin");
    }
    }
    private int girisYap(){
        System.out.println("");
        System.out.print("Giriş yapma seçeneği seçtiniz.");
        System.out.println();
        System.out.print("Giriş E-postanız: ");
        String eposta=scanner.next();//burda e-posta degiskeni yaratıp scanner ile atamamı yapacağım?
        System.out.print("Şifreniz: ");
        int sifre=scanner.nextInt();//burda sifre degiskeni yaratıp scanner ile atamamı yapacağım?
        Veritabani veritabani=new Veritabani();
        Kullanici kullanici=veritabani.getKullanici(eposta);//burda hata veriyor
        return kullanici.getKullaniciNumarasi();
        //devamını tam anlayamadım, Veritabanı ve hatalar sınıfına bağlı işlemler de görünüyor, onların bitmesi mi gerekli?

        return -1;
    }
    private int menuYazdir(){
    //İrem dolduracak
        return 0;
>>>>>>> Stashed changes
    }
        private int kayitOl(){
            //İrem dolduracak
            return 0;
        }
        private int cikisYap(){
            //İrem dolduracak
            return 0;
        }

    }
    static public class GirisSonrasi {
<<<<<<< Updated upstream
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
=======
        Scanner scan=new Scanner(System.in);
        private int menuYazdir(){
            System.out.println("[1] Kişilerin profiline göz at");
            System.out.println("[2] Kendi profiline göz at");
            System.out.println("[3] Yeni gönderi paylaş");
            System.out.println("[4] Kullanıcı bilgilerini değiştir");
            System.out.println("[5] Şifreyi değiştir");
            System.out.println("[6] Çıkış yap");
            System.out.println();
            System.out.println("Seçiminiz: ");
            int secim= scan.nextInt();
            return secim;
        }
        private void profilSayfasi(int secim){
            //İrem dolduracak
        }
    private void profilListesi(){
        System.out.println("Profil seçmek için profille eşleşen numarayı yazın. Geri dönmek için -1 yazın.");
        System.out.println();
        for (Kullanici kullanici:Veritabani.getKullanici()){
            System.out.println(kullanici.getKullaniciNumarasi()+" - "+kullanici.getKullaniciAdi()+" - "+ kullanici.getEposta());
        }
        System.out.print("Seçiminiz: ");
        int secim=scan.nextInt();

        if (secim==-1){
            profilListesi();
        }
        else {
            profilSayfasi(seim);
        }

    }
    private void sifreDegistir(){
        System.out.print("Eski şifreniz: ");
        String eskiSifre=scan.next();
        System.out.print("Yeni şifreniz: ");
        String yeniSifre=scan.next();
        System.out.print("Yeni şifreniz (tekrardan): ");
        String yeniSifreT=scan.next();
        Kullanici kullanici=new Kullanici(); //Burda hataneden veriyor acaba
        kullanici.sifre(eskiSifre,yeniSifre,yeniSifreT); //Burda hataneden veriyor acaba

        }
        private  void cikisYap(){
            scan.close();
            System.exit(0);
        }
>>>>>>> Stashed changes

        }
    }
}
