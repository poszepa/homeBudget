package homeBudget.model;

public class Wyplata {
    private int id;
    private Double wyplata;
    private String opis;
    private String dataDodania;
    private String userID;


    public Wyplata() {
    }




    public Wyplata(Double wyplata, String opis, String dataDodania, String userID) {
        this.wyplata = wyplata;
        this.opis = opis;
        this.dataDodania = dataDodania;
        this.userID = userID;
    }

    public Wyplata(int id, Double wyplata, String opis, String dataDodania, String userID) {
        this.id = id;
        this.wyplata = wyplata;
        this.opis = opis;
        this.dataDodania = dataDodania;
        this.userID = userID;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
