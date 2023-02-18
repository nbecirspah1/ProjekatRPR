package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class KategorijaDaoSQLImpl extends AbstractDao<Kategorija> implements KategorijaDao {
    private static KategorijaDaoSQLImpl instance = null;
    private  KategorijaDaoSQLImpl(){
        super("Kategorija");
    }

    public static KategorijaDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new KategorijaDaoSQLImpl();
        return instance;
    }
    @Override
    public Kategorija row2object (ResultSet rs) throws ProjekatException{
        try{
            Kategorija kat = new Kategorija();
            kat.setId(rs.getInt("id"));
            kat.setName(rs.getString("imeKategorije"));
            return kat;
        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (Kategorija object){
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("imeKategorije", object.getName());
        return row;
    }
}

