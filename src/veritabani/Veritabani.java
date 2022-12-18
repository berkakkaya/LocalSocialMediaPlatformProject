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
}
