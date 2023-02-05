package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.exceptions.ProjekatException;

public class KupacManager {

    public void validateKupacName(String ime) throws ProjekatException {
        if (ime == null || ime.length() <= 2 || !ime.matches("^[a-zA-Z]+$")) {
            throw new ProjekatException("Ime mora sadržavati samo slova, i dužina imena ne smije biti manja ili jednaka 2");
        }
    }

    public void validateKupacSurname(String prezime) throws ProjekatException {
        if (prezime == null || prezime.length() <= 2 || !prezime.matches("^[a-zA-Z]+$")) {
            throw new ProjekatException("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2");
        }
    }

    public void validateKupacPhoneNumber(String brojTel) throws ProjekatException {
        if (brojTel == null || brojTel.length() <= 6 || !brojTel.matches("^[a-zA-Z]+$")) {
            throw new ProjekatException("Prezime mora sadržavati samo slova, i dužina prezimena ne smije biti manja ili jednaka 2");
        }
    }

    public void validatePhoneNumber(String phoneNumber) throws ProjekatException {
        if (phoneNumber == null || !phoneNumber.matches("^\\+387[0-9]{9}$")) {
            throw new ProjekatException("Broj telefona mora biti u formatu +387XXXXXXXXX");
        }
    }

    public void validatePassword(String password) throws ProjekatException {
        if(password.length() < 8){
            throw new ProjekatException("Password mora sadržavati najmanje 8 karaktera.");

        }
    }

}
