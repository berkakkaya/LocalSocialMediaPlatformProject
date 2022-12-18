package veritabani;

import gonderi.Gonderi;
import kullanici.Kullanici;

import java.util.ArrayList;

public class Veritabani {
    private static final ArrayList<Gonderi> gonderiler = new ArrayList<>();
    private static final ArrayList<Kullanici> kullanicilar = new ArrayList<>();

    public static void addGonderi(Gonderi gonderi) {
        gonderiler.add(gonderi);
    }

    public static void addKullanici(Kullanici kullanici) {
        kullanicilar.add(kullanici);
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

        for (Gonderi gonderi: gonderiler) {
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

}
