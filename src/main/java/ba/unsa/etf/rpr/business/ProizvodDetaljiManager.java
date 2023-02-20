package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;


public class ProizvodDetaljiManager {

    ProizvodDetalji getByID(int placanjeID) throws ProjekatException {
        return DaoFactory.proizvodDetaljiDao().getById(placanjeID);
    }
}
