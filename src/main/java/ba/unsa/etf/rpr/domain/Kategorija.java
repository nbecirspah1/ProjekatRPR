package ba.unsa.etf.rpr.domain;

public class Kategorija implements Idable{
    private int id;
    private String name;
    private String gender;

    public Kategorija(String name, String gender) {
        this.name = name;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kategorija category = (Kategorija) o;
        return id == category.id;
    }
}
