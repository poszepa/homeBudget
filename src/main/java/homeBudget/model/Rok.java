package homeBudget.model;

public class Rok {
    private int id;
    private int rok;

    public Rok() {
    }

    public Rok(int id, int rok) {
        this.id = id;
        this.rok = rok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }
}
