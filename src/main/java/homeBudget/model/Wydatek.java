package homeBudget.model;

public class Wydatek {
    private int id;
    private String nazwaWydatku;
    private String opisWydatku;
    private double kwotaWydatku;
    private String dataDodania;


    public Wydatek() {
    }

    public Wydatek(String nazwaWydatku, String opisWydatku, double kwotaWydatku) {
        this.nazwaWydatku = nazwaWydatku;
        this.opisWydatku = opisWydatku;
        this.kwotaWydatku = kwotaWydatku;
    }

    public Wydatek(int id, String nazwaWydatku, String opisWydatku, double kwotaWydatku, String dataDodania) {
        this.id = id;
        this.nazwaWydatku = nazwaWydatku;
        this.opisWydatku = opisWydatku;
        this.kwotaWydatku = kwotaWydatku;
        this.dataDodania = dataDodania;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwaWydatku() {
        return nazwaWydatku;
    }

    public void setNazwaWydatku(String nazwaWydatku) {
        this.nazwaWydatku = nazwaWydatku;
    }

    public String getOpisWydatku() {
        return opisWydatku;
    }

    public void setOpisWydatku(String opisWydatku) {
        this.opisWydatku = opisWydatku;
    }

    public double getKwotaWydatku() {
        return kwotaWydatku;
    }

    public void setKwotaWydatku(double kwotaWydatku) {
        this.kwotaWydatku = kwotaWydatku;
    }

    public String getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(String dataDodania) {
        this.dataDodania = dataDodania;
    }
}
