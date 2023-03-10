package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Placanje;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class PlacanjeDaoSQLImpl extends AbstractDao<Placanje> implements PlacanjeDao{

    private static PlacanjeDaoSQLImpl instance = null;
    public PlacanjeDaoSQLImpl() {
        super("Placanje");
    }

    public static PlacanjeDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new PlacanjeDaoSQLImpl();
        return instance;
    }

    @Override
    public Placanje row2object(ResultSet rs) throws ProjekatException{
        try {
            Placanje placanje = new Placanje();
            placanje.setId(rs.getInt("id"));
            placanje.setPaymentDate(rs.getDate("DatumPlacanja"));
            placanje.setPaymentMethod(rs.getString("NacinPlacanja"));
            placanje.setKupacID(rs.getInt("kupacID"));
            placanje.setProizvodID(rs.getInt("proizvodID"));
            return placanje;
        }catch(SQLException e){
            throw  new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (Placanje object){
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("DatumPlacanja", object.getPaymentDate());
        row.put("NacinPlacanja", object.getPaymentMethod());
        row.put("kupacID", object.getKupacID());
        row.put("proizvodID", object.getProizvodID());
        return row;
    }

}
