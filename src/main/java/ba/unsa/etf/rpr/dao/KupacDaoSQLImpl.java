package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class KupacDaoSQLImpl extends AbstractDao<Kupac> implements KupacDao{

    private static KupacDaoSQLImpl instance = null;
    private KupacDaoSQLImpl() {
        super("Kupac");
    }

    public static KupacDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new KupacDaoSQLImpl();
        return instance;
    }
    @Override
    public Kupac row2object(ResultSet rs) throws ProjekatException{
        try{
            Kupac kupac = new Kupac();
            kupac.setId(rs.getInt("idKupac"));
            kupac.setName(rs.getString("ime"));
            kupac.setSurname(rs.getString("prezime"));
            kupac.setAdress(rs.getString("adresa"));
            kupac.setPhoneNumber(rs.getString("brojTelefona"));
            kupac.setPassword(rs.getString("password"));
            return kupac;
        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (Kupac object){
        Map<String, Object> row = new TreeMap<>();
        row.put("idKupac", object.getId());
        row.put("ime", object.getName());
        row.put("prezime", object.getSurname());
        row.put("adresa", object.getAdress());
        row.put("brojTelefona", object.getPhoneNumber());
        row.put("password", object.getPassword());

        return row;
    }
}
