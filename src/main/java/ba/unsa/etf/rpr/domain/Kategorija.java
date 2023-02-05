package ba.unsa.etf.rpr.domain;

public class Kategorija implements Idable{
    private int id;
    private int name;
    private int gender;

    public Kategorija(int name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
