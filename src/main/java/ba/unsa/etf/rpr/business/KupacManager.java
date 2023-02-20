package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

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


    public void validateKupacPhoneNumber(String phoneNumber) throws ProjekatException {
        if (phoneNumber == null || !phoneNumber.matches("^\\+387[0-9]{9}$")) {
            throw new ProjekatException("Broj telefona mora biti u formatu +387XXXXXXXXX");
        }
    }

    public void validateKupacPassword(String password) throws ProjekatException {
        if(password.length() < 8){
            throw new ProjekatException("Password mora sadržavati najmanje 8 karaktera.");

        }
    }
    public void validateKupacEmail(String email) throws ProjekatException {
        if(email == null){
            throw new ProjekatException("Email ne može biti null.");

        }

        if(!searchByEmail(email).isEmpty()){
            throw new ProjekatException("Već postoji account sa ovim emailom.");

        }
    }

    public List<Kupac> searchByEmail(String email) throws ProjekatException{
        try{
         return DaoFactory.kupacDao().searchByEmail(email);
        }
        catch(ProjekatException e){
            throw e;
        }
    }

    public Kupac add(Kupac kupac) throws ProjekatException{
        if(kupac.getId() != 0){
            throw new ProjekatException("Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.");
        }
        validateKupacName(kupac.getName());
        validateKupacSurname(kupac.getSurname());
        validateKupacPassword(kupac.getPassword());
        validateKupacPhoneNumber(kupac.getPhoneNumber());
        validateKupacEmail(kupac.getEmail());


        try{

            return DaoFactory.kupacDao().add(kupac);
        }catch(ProjekatException e){

            throw e;
        }

    }

    public List<Kupac> getAll() throws ProjekatException{
        return DaoFactory.kupacDao().getAll();
    }

    public Kupac getByID(int id) throws ProjekatException{
        return DaoFactory.kupacDao().getById(id);
    }

}
