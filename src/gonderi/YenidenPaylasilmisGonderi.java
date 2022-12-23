package gonderi;

import kullanici.Kullanici;

public class YenidenPaylasilmisGonderi extends Gonderi {

    private final NormalGonderi kaynakGonderi;

    public YenidenPaylasilmisGonderi(Kullanici kullanici, NormalGonderi kaynakGonderi) {
        super(kullanici);
        this.kaynakGonderi = kaynakGonderi;
    }

    public NormalGonderi getKaynakGonderi() {
        return kaynakGonderi;
    }

    public void yazdir() {
        System.out.println("[Yeniden Paylaşım]");
        System.out.println(super.getPaylasan().getAdSoyad() + " (" + super.getPaylasan().getKullaniciAdi() + ")");
        System.out.print("\n");
        System.out.println(kaynakGonderi.getIcerik());
        System.out.print("\n");
        System.out.println("[" + kaynakGonderi.getYenidenPaylasmaSayisi() + " yeniden paylaşım, " + kaynakGonderi.getBegenenSayisi() + " beğeni]");
    }
}
