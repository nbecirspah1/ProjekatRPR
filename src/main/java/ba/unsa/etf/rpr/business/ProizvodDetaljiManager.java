package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.util.List;


public class ProizvodDetaljiManager {

    public ProizvodDetalji getByProizvodIDAndSize(int proizvodID, String velicina) throws ProjekatException {
        return DaoFactory.proizvodDetaljiDao().getByProizvodIDAndSize(proizvodID, velicina);
    }

    public ProizvodDetalji update(ProizvodDetalji item) throws ProjekatException{
        return DaoFactory.proizvodDetaljiDao().update(item);
    }
}
