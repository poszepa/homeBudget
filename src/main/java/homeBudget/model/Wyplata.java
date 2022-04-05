package homeBudget.model;

public class Wyplata {
    private int id;
    private Double wyplata;
    private String opis;
    private String dataDodania;


    public Wyplata() {
    }

    public Wyplata(Double wyplata, String opis) {
        this.wyplata = wyplata;
        this.opis = opis;
    }

    public Wyplata(int id, Double wyplata, String opis, String dataDodania) {
        this.id = id;
        this.wyplata = wyplata;
        this.opis = opis;
        this.dataDodania = dataDodania;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getWyplata() {
        return wyplata;
    }

    public void setWyplata(Double wyplata) {
        this.wyplata = wyplata;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(String dataDodania) {
        this.dataDodania = dataDodania;
    }
}
