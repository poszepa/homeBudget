package homeBudget.model;

public class Miesiac {
    private int id;
    private String miesiac;

    public Miesiac(int id, String miesiac) {
        this.id = id;
        this.miesiac = miesiac;
    }

    public Miesiac() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public void setMiesiac(String miesiac) {
        this.miesiac = miesiac;
    }
}
