package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ProizvodDetalji;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class ProizvodDetaljiDaoSQLImpl extends AbstractDao<ProizvodDetalji> implements  ProizvodDetaljiDao{
    ProizvodDetaljiDaoSQLImpl(){super("ProizvodDetalji");}

    @Override
    public ProizvodDetalji row2object(ResultSet rs) throws ProjekatException{
        try{
            ProizvodDetalji pDetalji = new ProizvodDetalji();
            pDetalji.setId(rs.getInt("idProizvodDetalji"));
            pDetalji.setColor(rs.getString("boja"));
            pDetalji.setSize(rs.getString("velicina"));
            pDetalji.setStockLevel(rs.getInt("kolicinaNaStanju"));
            pDetalji.setProizvodID(rs.getInt("ProizvodID"));
            return pDetalji;
        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(ProizvodDetalji object){
        Map<String, Object> row = new TreeMap<>();
        row.put("idProizvodDetalji", object.getId());
        row.put("boja", object.getColor());
        row.put("velicina", object.getSize());
        row.put("kolicinaNaStanju", object.getStockLevel());
        row.put("ProizvodID", object.getProizvodID());

        return row;
    }
}
