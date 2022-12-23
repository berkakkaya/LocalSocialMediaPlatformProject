package kullanici;

import hatalar.SifreEslesmiyorException;
import hatalar.YanlisSifreException;
import veritabani.Veritabani;

public class Kullanici {
    private final int kullaniciNumarasi;
    private String adSoyad;
    private String ePosta;
    private final String kullaniciAdi;
    private String sifre;

    public Kullanici(String adSoyad, String ePosta, String kullaniciAdi, String sifre, String sifreYeniden) throws SifreEslesmiyorException {
        this.adSoyad = adSoyad;
        this.ePosta = ePosta;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciNumarasi = Veritabani.getNewKullaniciNumarasi();
        if (!sifre.equals(sifreYeniden)) {
            throw new SifreEslesmiyorException();
        }

        this.sifre = sifre;

    }
    public int getKullaniciNumarasi() {
        return this.kullaniciNumarasi;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEposta() {
        return ePosta;
    }

    public void setEposta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public boolean sifre(String sifre) {
        return this.sifre.equals(sifre);
    }

    public void sifre(String eskiSifre, String sifre, String sifreYeniden) throws YanlisSifreException, SifreEslesmiyorException {
        if (!this.sifre.equals(eskiSifre)) {
            throw new YanlisSifreException();
        }

        if (!sifre.equals(sifreYeniden)) {
            throw new SifreEslesmiyorException();
        }

        this.sifre = sifre;
    }
}
