package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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
            proizvod.setId(rs.getInt("id"));
            proizvod.setOpis(rs.getString("opisProizvoda"));
            proizvod.setCijena(rs.getDouble("cijena"));
         //   proizvod.setSlika(rs.getBinaryStream("slikaProizvoda"));
            InputStream inputStream = rs.getBinaryStream("slikaProizvoda");
            if (inputStream != null) {
                try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    proizvod.setSlika(outputStream.toByteArray());
                } catch (IOException e) {
                    throw new ProjekatException("Error reading image data from database", e);
                }
            }
            System.out.println("OVO JE KAO SLIKA " + proizvod.getSlika().length);
            return proizvod;
        } catch (SQLException e) {
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Proizvod object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("opisProizvoda", object.getOpis());
        row.put("cijena", object.getCijena());
        row.put("slikaProizvoda", object.getSlika());
        return row;
    }

    @Override
    public List<Proizvod> searchByCategory(Kategorija kategorija) throws ProjekatException{
        return executeQuery("SELECT * FROM freedb_rprProjekaBaza.Proizvod WHERE kategorijaID = ?", new Object[]{kategorija.getId()});

    }
}