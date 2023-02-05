package ba.unsa.etf.rpr.domain;

public class Proizvod implements Idable {
    private int id;
    private double cijena;
    private String opis;
    private int kategorijaID;

    public Proizvod(double cijena, String opis, int kategorijaID) {
        this.cijena = cijena;
        this.opis = opis;
        this.kategorijaID = kategorijaID;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(int kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proizvod p = (Proizvod) o;
        return id == p.id;
    }
}
