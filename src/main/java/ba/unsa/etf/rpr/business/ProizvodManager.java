package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

public class ProizvodManager {
    public List<Proizvod> getAll() throws ProjekatException {
        return DaoFactory.proizvodDao().getAll();
    }


    public List<Proizvod> getByCategory(String imeKategorije) throws ProjekatException{
        Kategorija kategorijaID = getIDKategorije(imeKategorije);
        return DaoFactory.proizvodDao().searchByCategory(kategorijaID);

    }


    public Kategorija getIDKategorije(String imeKategorije) throws ProjekatException{
        return DaoFactory.kategorijaDao().getIDofCategory(imeKategorije);
    }

    public List<Proizvod> searchByPriceAndCategory(int cijena, String kategorija) throws ProjekatException{
        if(kategorija=="-"){
            return DaoFactory.proizvodDao().searchByPrice(cijena);

        }
        Kategorija kategorijaID = getIDKategorije(kategorija);
        return DaoFactory.proizvodDao().searchByPriceAndCateogry(cijena, kategorijaID);
    }
}
