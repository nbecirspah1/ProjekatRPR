package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Placanje;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

public class PlacanjeManager {

    public Placanje add(Placanje placanje) throws ProjekatException {
        if(placanje.getId() != 0){
            throw new ProjekatException("Kategorija sa postojećim ID-em se ne može dodati. ID mora biti automatski generisan.");
        }

        try{

            return DaoFactory.placanjeDao().add(placanje);
        }catch(ProjekatException e){

            throw e;
        }

    }


}
