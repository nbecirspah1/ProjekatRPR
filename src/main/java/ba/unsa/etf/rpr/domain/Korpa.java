package ba.unsa.etf.rpr.domain;

public class Korpa implements Idable{
    private int id;
    private int proizvodID;
    private int totalCost;

    public Korpa(int proizvodID, int totalCost) {
        this.proizvodID = proizvodID;
        this.totalCost = totalCost;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
