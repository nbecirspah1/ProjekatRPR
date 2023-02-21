package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Placanje implements Idable{
    private int id;
    private Date paymentDate;
    private String paymentMethod;

    private int kupacID;
    private int proizvodID;




    public Placanje() {

    }

    public Placanje(int id, Date paymentDate, String paymentMethod, int kupacID, int proizvodID) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.kupacID = kupacID;
        this.proizvodID = proizvodID;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public int getId() {
        return id;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placanje payment = (Placanje) o;
        return id == payment.id;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }
}
