package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDaoSQLImpl extends AbstractDao<Proizvod> implements ProizvodDao {
    private ProizvodDaoSQLImpl() {
        super("Proizvod");
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
}