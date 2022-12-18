package kullanici;

import hatalar.SifreEslesmiyorException;
import hatalar.YanlisSifreException;

public class Kullanici{
    private final int kullaniciNumarasi=0; //Şimdilik 0'a eşitlendi error önlenmesi için
    private String adSoyad;
    private String ePosta;
    private final String kullaniciAdi;
    private String sifre;

    public Kullanici(String adSoyad, String ePosta, String kullaniciAdi, String sifre, String sifreYeniden ){
        this.adSoyad = adSoyad;
        this.ePosta = ePosta;
        this.kullaniciAdi = kullaniciAdi;
        if(sifre != sifreYeniden){
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

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public boolean sifre(String sifre){
        if(this.sifre != sifre){
            return false;
        }else{
            return true;
        }
    }

    public void sifre(String eskiSifre, String sifre, String sifreYeniden){
       if(this.sifre != eskiSifre) {
           throw new YanlisSifreException();
       }
       
       if(sifre != sifreYeniden) {
           throw new SifreEslesmiyorException();
       }
       
       this.sifre = sifre;
    }
}
