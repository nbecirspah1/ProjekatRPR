package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Proizvod;

public class DaoFactory {

    private static final KategorijaDao kategorijaDao = KategorijaDaoSQLImpl.getInstance();
    private static final KorpaDao korpaDao = KorpaDaoSQLImpl.getInstance();
    private static final KupacDao kupacDao = KupacDaoSQLImpl.getInstance();
    private static final PlacanjeDao placanjeDao = PlacanjeDaoSQLImpl.getInstance();
    private static final ProizvodDao proizvodDao = ProizvodDaoSQLImpl.getInstance();
    private static final ProizvodDetaljiDao proizvodDetaljiDao = ProizvodDetaljiDaoSQLImpl.getInstance();

    public static KategorijaDao kategorijaDao(){return kategorijaDao;}
    public static KorpaDao korpaDao() {return korpaDao;}
    public static KupacDao kupacDao() {return kupacDao;}
    public static PlacanjeDao placanjeDao() {return placanjeDao;}
    public static ProizvodDao proizvodDao() {return proizvodDao;}
    public static ProizvodDetaljiDao proizvodDetaljiDao() {return proizvodDetaljiDao;}


}
