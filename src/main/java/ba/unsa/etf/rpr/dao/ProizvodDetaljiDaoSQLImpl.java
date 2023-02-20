package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDetaljiDaoSQLImpl extends AbstractDao<ProizvodDetalji> implements  ProizvodDetaljiDao{

    private static ProizvodDetaljiDaoSQLImpl instance = null;
    ProizvodDetaljiDaoSQLImpl(){super("ProizvodDetalji");}

    public static ProizvodDetaljiDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ProizvodDetaljiDaoSQLImpl();
        return instance;
    }

    @Override
    public ProizvodDetalji row2object(ResultSet rs) throws ProjekatException{
        try{
            ProizvodDetalji pDetalji = new ProizvodDetalji();
            pDetalji.setId(rs.getInt("id"));
            pDetalji.setColor(rs.getString("boja"));
            pDetalji.setSize(rs.getString("velicina"));
            pDetalji.setStockLevel(rs.getInt("kolicinaNaStanju"));
            pDetalji.setProizvodID(rs.getInt("proizvodID"));
            return pDetalji;
        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(ProizvodDetalji object){
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("boja", object.getColor());
        row.put("velicina", object.getSize());
        row.put("kolicinaNaStanju", object.getStockLevel());
        row.put("proizvodID", object.getProizvodID());

        return row;
    }

    @Override
    public List<ProizvodDetalji> getByProizvodID(int proizvodID) throws ProjekatException {
        return executeQuery("SELECT * FROM freedb_rprProjekaBaza.ProizvodDetalji WHERE proizvodID = ?", new Object[]{proizvodID});

    }
}
