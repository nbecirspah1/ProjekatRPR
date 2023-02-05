package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

public interface ProizvodDao extends Dao<Proizvod>{
    List<Proizvod> searchByCategory(Kategorija kategorija) throws ProjekatException;
}
