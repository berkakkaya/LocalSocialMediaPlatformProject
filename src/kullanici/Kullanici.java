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
        this.sifre = sifre;
        if(sifreYeniden != sifre){
            try {
                throw new SifreEslesmiyorException();
            } catch (SifreEslesmiyorException e) {
                throw new RuntimeException(e);
            }
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

    public boolean sifre(String sifre){
        if(this.sifre != sifre){
            return false;
        }else{
            return true;
        }
    }

    public void sifre(String eskiSifre, String sifre, String sifreYeniden){
        if(this.sifre != eskiSifre){
            try {
                throw new YanlisSifreException();
            } catch (YanlisSifreException e) {
                throw new RuntimeException(e);
            }
        }else{
            if(sifre != sifreYeniden){
                try {
                    throw new SifreEslesmiyorException();
                } catch (SifreEslesmiyorException e) {
                    throw new RuntimeException(e);
                }
            }else{
                this.sifre = sifre;
            }
        }
    }
}
