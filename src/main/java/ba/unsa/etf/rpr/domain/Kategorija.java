package ba.unsa.etf.rpr.domain;

public class Kategorija implements Idable{
    private int id;
    private String name;

    public Kategorija(String name, String gender) {
        this.name = name;
    }

    public Kategorija() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija category = (Kategorija) o;
        return id == category.id;
    }
}
