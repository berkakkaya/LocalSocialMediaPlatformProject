package gonderi;

import kullanici.Kullanici;

public class YenidenPaylasilmisGonderi extends Gonderi {

    private NormalGonderi kaynakGonderi;
    public YenidenPaylasilmisGonderi(Kullanici kullanici, NormalGonderi kaynakGonderi){
        super(kullanici);
        this.kaynakGonderi = kaynakGonderi;
    }

    public void yazdir(){
        System.out.println("[Yeniden Paylaşım]");
        System.out.println(super.getPaylasan().getKullaniciAdi() + " ( "+ super.getPaylasan().getEposta()+ " )");
        System.out.println("\n");
        System.out.println(kaynakGonderi);
        System.out.println("\n");
        System.out.println("[" + kaynakGonderi.getYenidenPaylasmaSayisi() + " yeniden paylaşım, " + kaynakGonderi.getBegenenSayisi() + " beğeni]");
    }
}
