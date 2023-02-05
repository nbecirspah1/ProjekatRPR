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
            placanje.setId(rs.getInt("idPlacanje"));
            placanje.setKorpaID(rs.getInt("korpaID"));
            placanje.setPaymentDate(rs.getDate("DatumPlacanja"));
            placanje.setPaymentMethod(rs.getString("NacinPlacanja"));
            return placanje;
        }catch(SQLException e){
            throw  new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (Placanje object){
        Map<String, Object> row = new TreeMap<>();
        row.put("idPlacanje", object.getId());
        row.put("korpaID", object.getKorpaID());
        row.put("DatumPlacanja", object.getPaymentDate());
        row.put("NacinPlacanja", object.getPaymentMethod());
        return row;
    }

}
