package veritabani;

import gonderi.Gonderi;
import hatalar.GonderiBulunamadiException;
import hatalar.KullaniciBulunamadiException;
import kullanici.Kullanici;

import java.util.ArrayList;

public class Veritabani {
    private static final ArrayList<Gonderi> gonderiler = new ArrayList<>();
    private static final ArrayList<Kullanici> kullanicilar = new ArrayList<>();
    private static int sonrakiGonderiNumarasi = 0;
    private static int sonrakiKullaniciNumarasi = 0;

    public Veritabani() {
        System.out.println("UYARI: Veritabani sınıfını direkt oluşturmayın.");
    }

    public static void addGonderi(Gonderi gonderi) {
        gonderiler.add(gonderi);
        sonrakiGonderiNumarasi++;
    }

    public static void addKullanici(Kullanici kullanici) {
        kullanicilar.add(kullanici);
        sonrakiKullaniciNumarasi++;
    }

    public static Gonderi getGonderi(int gonderiNumarasi) throws GonderiBulunamadiException {
        try {
            return gonderiler.get(gonderiNumarasi);
        } catch (IndexOutOfBoundsException e) {
            throw new GonderiBulunamadiException();
        }
    }

    public static ArrayList<Gonderi> getGonderi(Kullanici kullanici) {
        ArrayList<Gonderi> dondurulecekGonderiler = new ArrayList<>();

        for (Gonderi gonderi: gonderiler){
            if (gonderi.getPaylasan() == kullanici) {
                dondurulecekGonderiler.add(gonderi);
            }
        }

        return dondurulecekGonderiler;
    }
    public static ArrayList<Kullanici> getKullanici() {
        return kullanicilar;
    }

    public static Kullanici getKullanici(int kullaniciNumarasi) throws KullaniciBulunamadiException {
        try {
            return kullanicilar.get(kullaniciNumarasi);
        } catch (IndexOutOfBoundsException e) {
            throw new KullaniciBulunamadiException();
        }
    }

    public static Kullanici getKullanici(String ePosta) throws KullaniciBulunamadiException {
        for (Kullanici kullanici: kullanicilar) {
            if (kullanici.getEposta().equals(ePosta)) {
                return kullanici;
            }
        }

        throw new KullaniciBulunamadiException();
    }

    public static int yeniGonderiNumarasiAl() {
        return sonrakiGonderiNumarasi;
    }

    public static int yeniKullaniciNumarasiAl() {
        return sonrakiKullaniciNumarasi;
    }
}
