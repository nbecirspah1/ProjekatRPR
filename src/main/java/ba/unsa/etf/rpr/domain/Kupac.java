package ba.unsa.etf.rpr.domain;

public class Kupac implements Idable {

    private int id;
    private String name;
    private String surname;
    private String adress;
    private String phoneNumber;
    private String password;

    public Kupac(String name, String surname, String adress, String phoneNumber, String password) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kupac kupac = (Kupac) o;
        return id == kupac.id;
    }
}
