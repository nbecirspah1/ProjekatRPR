package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;


public class ProizvodDetaljiManager {

    public List<ProizvodDetalji> getByProizvodID(int proizvodID) throws ProjekatException {
        return DaoFactory.proizvodDetaljiDao().getByProizvodID(proizvodID);
    }

    public ProizvodDetalji update(ProizvodDetalji item) throws ProjekatException{
        return DaoFactory.proizvodDetaljiDao().update(item);
    }
}
