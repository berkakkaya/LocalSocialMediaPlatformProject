package kullanici;

import hatalar.SifreEslesmiyorException;

public class Kullanici{
    private final int kullaniciNumarasi;
    private String adSoyad;
    private String ePosta;
    private final String kullaniciAdi;
    private String sifre;

    public Kullanici(String adSoyad, String ePosta, String kullaniciAdi, String sifre, String sifreYeniden ){
        this.adSoyad = adSoyad;
        this.ePosta = ePosta;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        if(sifreYeniden != sifre){
           throw new SifreEslesmiyorException("Yazdığınız şifre, ilk yazdığınız şifre ile uyuşmuyor.");
        }
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
}
