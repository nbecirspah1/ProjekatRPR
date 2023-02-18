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


}
