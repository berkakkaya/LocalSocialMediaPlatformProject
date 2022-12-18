package gonderi;

import kullanici.Kullanici;

public abstract class Gonderi {
    private int gonderiNumarasi;
    private final Kullanici paylasan;

    public Gonderi(Kullanici paylasan) {
        this.paylasan = paylasan;
    }

    public int getGonderiNumarasi() {
        return gonderiNumarasi;
    }

    public Kullanici getPaylasan() {
        return paylasan;
    }

    public abstract void yazdir();
}
