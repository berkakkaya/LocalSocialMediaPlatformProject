package gonderi;

import kullanici.Kullanici;

import java.util.ArrayList;

public class NormalGonderi extends Gonderi {
    private final ArrayList<Integer> begenenler;
    private final String icerik;
    private int yenidenPaylasmaSayisi;

    public NormalGonderi(Kullanici kullanici, String icerik) {
        super(kullanici);
        this.icerik = icerik;
        this.begenenler = new ArrayList<>();
        this.yenidenPaylasmaSayisi = 0;
    }

    public void begen(Kullanici kullanici) {
        final int kullaniciNumarasi = kullanici.getKullaniciNumarasi();
        final int index = this.begenenler.indexOf(kullaniciNumarasi);

        if (index == -1) {
            this.begenenler.add(kullaniciNumarasi);
            return;
        }

        this.begenenler.remove(index);
    }

    public boolean checkBegen(Kullanici kullanici) {
        final int kullaniciNumarasi = kullanici.getKullaniciNumarasi();
        final int index = this.begenenler.indexOf(kullaniciNumarasi);

        // Aşağıda eşit değildir operatörü üzerinden boolean elde ediliyor
        return index != -1;
    }

    protected int getBegenenSayisi() {
        return this.begenenler.size();
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

    public void yenidenPaylas(Kullanici kullanici) {
        // TODO: YenidenPaylasilmisGonderi sınıfı bitirilince buraya geri dön.
    }
}
