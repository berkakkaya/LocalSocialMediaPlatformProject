package gonderi;

public class YenidenPaylasilmisGonderi extends Gonderi {
    public YenidenPaylasilmisGonderi() {
        super(paylasan, gonderiNumarasi);
    }
    private NormalGonderi kaynakGonderi;
    public NormalGonderi kaynakGonderi(){

        return null;
    }

    @Override
    public void yazdir() {
        //dolacak
    }
}
