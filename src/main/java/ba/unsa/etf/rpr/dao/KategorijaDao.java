package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

public interface KategorijaDao extends  Dao<Kategorija> {
    Kategorija getIDofCategory (String imeKategorije) throws ProjekatException;
}
