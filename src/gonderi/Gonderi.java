package gonderi;

import kullanici.Kullanici;
import veritabani.Veritabani;

public abstract class Gonderi {
    private final int gonderiNumarasi;
    private final Kullanici paylasan;

    public Gonderi(Kullanici paylasan) {
        this.gonderiNumarasi = Veritabani.getNewGonderiNumarasi();
        this.paylasan = paylasan;
    }

    public int getGonderiNumarasi() {
        return gonderiNumarasi;
    }

    public Kullanici getPaylasan() {
        return paylasan;
    }

    public abstract void yazdir();

    public abstract void begen(Kullanici kullanici);

    public abstract boolean checkBegen(Kullanici kullanici);

    protected abstract int getBegenenSayisi();

    public abstract void yenidenPaylas(Kullanici kullanici);
}
