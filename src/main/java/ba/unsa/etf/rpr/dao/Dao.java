package ba.unsa.etf.rpr.dao;

import exceptions.ProjekatException;

import java.util.List;

/**
 * Root interface za sve DAO klase
 * @author Nejla Becirspahic
 */
public interface Dao<T> {
    /**
     *
     * @param id primarni kljuc entiteta
     * @return
     * @throws ProjekatException
     */
    T getById(int id) throws ProjekatException;

    /**
     *
     * @param item koji je potrebno dodati u bazu
     * @return dodani item
     * @throws ProjekatException
     */
    T add(T item) throws ProjekatException;

    /**
     * Update elementa bazirano na id poklapanju
     * @param item
     * @return updateovani item
     * @throws ProjekatException
     */
    T update(T item) throws  ProjekatException;

    /**
     * Brisanje elementa sa odgovarajućim id-em
     * @param id
     * @throws ProjekatException
     */
    void delete(int id) throws ProjekatException;

    /**
     *  WARNING: Jako spora operacija
     * @return Lista elementa iz baze
     * @throws ProjekatException
     */
    List<T> getAll() throws  ProjekatException;

}
