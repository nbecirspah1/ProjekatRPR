package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;

public interface ProizvodDetaljiDao extends Dao<ProizvodDetalji> {

    List<ProizvodDetalji> getByProizvodID(int proizvodID) throws ProjekatException;

    ProizvodDetalji getByProizvodIDAndSize(int proizvodID, String velicina) throws ProjekatException;
}
