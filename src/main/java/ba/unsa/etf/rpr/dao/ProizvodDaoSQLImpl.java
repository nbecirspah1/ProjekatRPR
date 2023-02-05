package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDaoSQLImpl extends AbstractDao<Proizvod> implements ProizvodDao {
    private static ProizvodDaoSQLImpl instance = null;
    private ProizvodDaoSQLImpl() {
        super("Proizvod");
    }

    public static ProizvodDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ProizvodDaoSQLImpl();
        return instance;
    }

    @Override
    public Proizvod row2object(ResultSet rs) throws ProjekatException {
        try {
            Proizvod proizvod = new Proizvod();
            proizvod.setId(rs.getInt("idProizvod"));
            proizvod.setOpis(rs.getString("opisProizvoda"));
            proizvod.setCijena(rs.getDouble("cijena"));
            proizvod.setKategorijaID(rs.getInt("kategorijaID"));
            return proizvod;
        } catch (SQLException e) {
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvod object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("idProizvod", object.getId());
        row.put("opisProizvoda", object.getOpis());
        row.put("cijena", object.getCijena());
        row.put("kategorijaID", object.getKategorijaID());

        return row;
    }

    @Override
    public List<Proizvod> searchByCategory(Kategorija kategorija) throws ProjekatException{
        return executeQuery("SELECT * FROM quotes WHERE kategorijaID = ?", new Object[]{kategorija.getId()});
    }
}