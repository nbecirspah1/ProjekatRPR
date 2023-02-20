package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;


public class ProizvodDetaljiManager {

    public ProizvodDetalji getByID(int proizvodID) throws ProjekatException {
        return DaoFactory.proizvodDetaljiDao().getById(proizvodID);
    }

    public ProizvodDetalji update(ProizvodDetalji item) throws ProjekatException{
        return DaoFactory.proizvodDetaljiDao().update(item);
    }
}
