package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Placanje implements Idable{
    private int id;
    private int korpaID;
    private Date paymentDate;
    private String paymentMethod;


    public Placanje(int korpaID, Date paymentDate, String paymentMethod) {
        this.korpaID = korpaID;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setKorpaID(int korpaID) {
        this.korpaID = korpaID;
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

    public int getKorpaID() {
        return korpaID;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
