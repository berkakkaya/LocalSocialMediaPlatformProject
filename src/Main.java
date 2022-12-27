import arayuz.Ekranlar;
import gonderi.NormalGonderi;
import hatalar.SifreEslesmiyorException;
import kullanici.Kullanici;
import veritabani.Veritabani;

public class Main {
    public static void main(String[] args) {
        testVerisiniYukle();

        Ekranlar.AnaEkran anaEkran = new Ekranlar.AnaEkran();
        anaEkran.calistir();
    }

    private static void testVerisiniYukle() {
        try {
            Kullanici ahmet = new Kullanici("Ahmet Burak", "ahmetburak@gmail.com", "@ahmet123", "ahmet123", "ahmet123");
            Veritabani.addKullanici(ahmet);

            Kullanici merve = new Kullanici("Merve Özkaya", "merveozkaya@gmail.com", "@merveeozkaya", "merve431", "merve431");
            Veritabani.addKullanici(merve);

            // Ahmet'in gönderileri
            NormalGonderi ahmet1 = new NormalGonderi(ahmet, "Bugün hava ne kadar güzel...");
            Veritabani.addGonderi(ahmet1);

            NormalGonderi ahmet2 = new NormalGonderi(ahmet, "Bugün basket maçını kazandığımız için çok mutluyum!");
            Veritabani.addGonderi(ahmet2);

            // Merve'nin gönderileri
            NormalGonderi merve1 = new NormalGonderi(merve, "Çektiğim bir gökkuşağı fotoğrafının görüntüsü...");
            Veritabani.addGonderi(merve1);

            ahmet1.yenidenPaylas(merve);
            ahmet2.yenidenPaylas(merve);

            NormalGonderi merve2 = new NormalGonderi(merve, "İzmir gibi güzel bir şehir yok. :)");
            Veritabani.addGonderi(merve2);

            // Gönderi beğenme
            ahmet1.begen(merve);
            ahmet1.begen(ahmet);

            merve1.begen(ahmet);
        } catch (SifreEslesmiyorException e) {
            throw new RuntimeException(e);
        }
    }
}