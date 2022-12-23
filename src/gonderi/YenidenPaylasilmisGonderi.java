package gonderi;

import kullanici.Kullanici;

public class YenidenPaylasilmisGonderi extends Gonderi {

    private final NormalGonderi kaynakGonderi;

    public YenidenPaylasilmisGonderi(Kullanici kullanici, NormalGonderi kaynakGonderi) {
        super(kullanici);
        this.kaynakGonderi = kaynakGonderi;
    }

    public void yazdir() {
        System.out.println("[Yeniden Paylaşım]");
        System.out.println(super.getPaylasan().getAdSoyad() + " (" + super.getPaylasan().getKullaniciAdi() + ")");
        System.out.print("\n");
        System.out.println(kaynakGonderi.getIcerik());
        System.out.print("\n");
        System.out.println("[" + kaynakGonderi.getYenidenPaylasmaSayisi() + " yeniden paylaşım, " + kaynakGonderi.getBegenenSayisi() + " beğeni]");
    }

    @Override
    public void begen(Kullanici kullanici) {
        this.kaynakGonderi.begen(kullanici);
    }

    @Override
    public boolean checkBegen(Kullanici kullanici) {
        return this.kaynakGonderi.checkBegen(kullanici);
    }

    @Override
    protected int getBegenenSayisi() {
        return this.kaynakGonderi.getBegenenSayisi();
    }

    @Override
    public void yenidenPaylas(Kullanici kullanici) {
        this.kaynakGonderi.yenidenPaylas(kullanici);
    }
}
