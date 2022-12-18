package kullanici;

import hatalar.SifreEslesmiyorException;
import hatalar.YanlisSifreException;

public class Kullanici {
    private final int kullaniciNumarasi = 0; //Şimdilik 0'a eşitlendi error önlenmesi için
    private String adSoyad;
    private String ePosta;
    private final String kullaniciAdi;
    private String sifre;

    public Kullanici(String adSoyad, String ePosta, String kullaniciAdi, String sifre, String sifreYeniden) throws SifreEslesmiyorException {
        this.adSoyad = adSoyad;
        this.ePosta = ePosta;
        this.kullaniciAdi = kullaniciAdi;
        if (!sifre.equals(sifreYeniden)) {
            throw new SifreEslesmiyorException();
        }

        this.sifre = sifre;
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
