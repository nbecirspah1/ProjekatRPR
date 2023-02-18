package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
            kupac.setId(rs.getInt("id"));
            kupac.setName(rs.getString("ime"));
            kupac.setSurname(rs.getString("prezime"));
            kupac.setAdress(rs.getString("adresa"));
            kupac.setPhoneNumber(rs.getString("brojTelefona"));
            kupac.setPassword(rs.getString("password"));
            kupac.setEmail(rs.getString("email"));
            return kupac;
        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row (Kupac object){
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("ime", object.getName());
        row.put("prezime", object.getSurname());
        row.put("adresa", object.getAdress());
        row.put("brojTelefona", object.getPhoneNumber());
        row.put("password", object.getPassword());
        row.put("email", object.getEmail());

        return row;
    }

    @Override
    public List<Kupac> searchByEmail(String email) throws ProjekatException{
        return executeQuery("SELECT * FROM freedb_rprProjekaBaza.Kupac WHERE email = ?", new Object[]{email});
    }
}
