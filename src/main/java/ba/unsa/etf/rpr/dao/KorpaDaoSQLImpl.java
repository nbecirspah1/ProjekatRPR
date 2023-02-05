package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Korpa;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class KorpaDaoSQLImpl extends AbstractDao<Korpa> implements KorpaDao{

    private static KorpaDaoSQLImpl instance = null;

    private KorpaDaoSQLImpl(){super("Korpa");}

    public static KorpaDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new KorpaDaoSQLImpl();
        return instance;
    }


    @Override
    public Korpa row2object(ResultSet rs) throws ProjekatException {
     try{
         Korpa korpa = new Korpa();
         korpa.setId(rs.getInt("idKorpa"));
         korpa.setProizvodID(rs.getInt("ProizvodID"));
         korpa.setTotalCost(rs.getInt("ukupnaCijena"));
         return korpa;
     }catch(SQLException e){
         throw new ProjekatException(e.getMessage(), e);
     }
    }

    @Override
    public Map<String, Object> object2row (Korpa object){
        Map<String, Object> row = new TreeMap<>();
        row.put("idKorpa", object.getId());
        row.put("ProizvodID", object.getProizvodID());
        row.put("ukupnaCijena", object.getTotalCost());

        return row;
    }
}

