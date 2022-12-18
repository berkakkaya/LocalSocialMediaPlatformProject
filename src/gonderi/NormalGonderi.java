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

}
