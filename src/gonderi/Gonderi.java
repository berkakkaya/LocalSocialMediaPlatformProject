package gonderi;

public abstract class Gonderi {
    private int gonderiNumarasi;
    private String paylasan;

    public Gonderi(int gonderiNumarasi, String paylasan){
        this.gonderiNumarasi = gonderiNumarasi;
        this.paylasan = paylasan;
    }

     public abstract void Gonderi();

    public int getGonderiNumarasi() {
        return gonderiNumarasi;
    }
    public String getPaylasan() {
        return paylasan;
    }
    public abstract void yazdir();//abstract method olduğu için içi boş
}
