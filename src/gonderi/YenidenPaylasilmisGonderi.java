package gonderi;

import kullanici.Kullanici;

public class YenidenPaylasilmisGonderi extends Gonderi {

    private NormalGonderi kaynakGonderi;
    public YenidenPaylasilmisGonderi(Kullanici kullanici){
        super(kullanici);
    }
    public YenidenPaylasilmisGonderi(NormalGonderi kaynakGonderi){
        this.kaynakGonderi = kaynakGonderi;
    }
    
}
