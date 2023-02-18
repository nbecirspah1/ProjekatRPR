package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

public interface KupacDao extends Dao<Kupac>{
    List<Kupac> searchByEmail(String text) throws ProjekatException;

}
