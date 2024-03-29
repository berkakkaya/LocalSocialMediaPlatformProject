package gonderi;

import kullanici.Kullanici;
import veritabani.Veritabani;

import java.util.ArrayList;

public class NormalGonderi extends Gonderi {
    private final ArrayList<Integer> begenenler; // Integer: sarmayalan sınıf
    private final String icerik;
    private int yenidenPaylasmaSayisi;

    public NormalGonderi(Kullanici kullanici, String icerik) {
        super(kullanici);
        this.icerik = icerik;
        this.begenenler = new ArrayList<>();
        this.yenidenPaylasmaSayisi = 0;
    }

    @Override
    public void begen(Kullanici kullanici) {
        final int kullaniciNumarasi = kullanici.getKullaniciNumarasi();

        // Kullanıcı gönderiyi beğenmiş mi diye kontrol et
        final int index = this.begenenler.indexOf(kullaniciNumarasi);

        if (index == -1) {
            this.begenenler.add(kullaniciNumarasi);
            return;
        }

        this.begenenler.remove(index);
    }

    @Override
    public boolean checkBegen(Kullanici kullanici) {
        final int kullaniciNumarasi = kullanici.getKullaniciNumarasi();

        // Kullanıcı gönderiyi beğenmiş mi diye kontrol et
        // -1 ise listede yok
        final int index = this.begenenler.indexOf(kullaniciNumarasi);

        // Aşağıda eşit değildir operatörü üzerinden boolean elde ediliyor
        return index != -1;
    }

    @Override
    protected int getBegenenSayisi() {
        return this.begenenler.size();
    }

    public String getIcerik() {
        return icerik;
    }

    protected int getYenidenPaylasmaSayisi() {
        return this.yenidenPaylasmaSayisi;
    }

    @Override
    public void yazdir() {
        System.out.println("[Gönderi]\n");
        System.out.println(this.icerik + "\n");
        System.out.println("[" + this.yenidenPaylasmaSayisi + " yeniden paylaşım, " + this.getBegenenSayisi() + " beğeni]");
    }

    @Override
    public void yenidenPaylas(Kullanici kullanici) {
        /*
        * Create a new reshared post
        * NOTE: When we use "this" as a parameter, we refer this class as a post.
        * */
        YenidenPaylasilmisGonderi gonderi = new YenidenPaylasilmisGonderi(kullanici, this);

        // Add newly created reshared post to our database
        Veritabani.addGonderi(gonderi);

        // Increase our repost counter by 1
        this.yenidenPaylasmaSayisi++;
    }
}
