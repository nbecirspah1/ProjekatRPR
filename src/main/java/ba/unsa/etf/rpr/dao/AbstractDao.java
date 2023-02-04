package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;
import ba.unsa.etf.rpr.exceptions.ProjekatException;

import java.sql.*;
import java.util.*;

public abstract class AbstractDao<T extends Idable> implements Dao<T>{
    private static Connection connection = null;
    private String imeTabele;

    public AbstractDao(String imeTabele){
        this.imeTabele = imeTabele;
        createConnection();
    }

    private static void createConnection(){
        if(AbstractDao.connection == null){
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                AbstractDao.connection = DriverManager.getConnection(url, username, password);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Runtime.getRuntime().addShutdownHook(new Thread(){
                    @Override
                    public void run(){
                        try{
                            connection.close();
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public static Connection getConnection(){
        return AbstractDao.connection;
    }

    /**
     * Method for mapping ResultSet into Object
     * @param rs - result set from database
     * @return a Bean object for specific table
     * @throws ProjekatException in case of error with db
     */
    public abstract T row2object(ResultSet rs) throws ProjekatException;

    /**
     * Method for mapping Object into Map
     * @param object - a bean object for specific table
     * @return key, value sorted map of object
     */
    public abstract Map<String, Object> object2row(T object);

    public T getById(int id) throws ProjekatException{
        return executeQueryUnique("SELECT * FROM" + this.imeTabele + "WHERE id = ?", new Object[]{id});
    }
    public List<T> getAll() throws ProjekatException{
        return executeQuery("SELECT * FROM " + this.imeTabele, null);
    }

    public void delete(int id) throws ProjekatException{
        String query = "DELETE FROM" + this.imeTabele + "WHERE id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(query);
            statement.setObject(1, id);
            statement.executeUpdate();

        }catch(SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

 /*   public T add(T item) throws ProjekatException{
        Map<String, Object> row = object2row(item);
        Map.Entry<String, String> columns = prepareInsertParts(row);

    }*/
    /**
     * This method represents utility method which is used
     * for executing any kind of query
     * @param query
     * @param params
     * @return List of objects
     * @throws ProjekatException
     */
    public List<T> executeQuery(String query, Object[] params) throws ProjekatException{
        try{
            PreparedStatement statement = getConnection().prepareStatement(query);
            if(params != null){
                for(int i=1; i<params.length; i++){
                    statement.setObject(i, params[i-1]);
                }
            }
            ResultSet rSet = statement.executeQuery();
            ArrayList<T> resultList = new ArrayList<>();
            while(rSet.next()){
                resultList.add(row2object(rSet));
            }
            return resultList;
        } catch (SQLException e){
            throw new ProjekatException(e.getMessage(), e);
        }
    }

    /**
     * Utility method that always returns single record
     * @param query
     * @param params
     * @return Object
     * @throws ProjekatException - when object is not found
     */
    public T executeQueryUnique(String query, Object[] params) throws  ProjekatException{
        List<T> result = executeQuery(query, params);
        if(result != null && result.size() == 1){
            return result.get(0);
        }else{
            throw new ProjekatException("Object not found.");
        }
    }

    private Map.Entry<String, String> prepareInsertParts(Map<String, Object> row){
        StringBuilder columns = new StringBuilder();
        StringBuilder questions = new StringBuilder();
        int i =0;
        for(Map.Entry<String, Object> entry : row.entrySet()){
            i++;
            if(entry.getKey().equals("id")) continue;
            columns.append(entry.getKey());
            questions.append("?");
            if(row.size() != i){
                columns.append(",");
                questions.append(",");
            }
        }
        return new AbstractMap.SimpleEntry<>(columns.toString(), questions.toString());
    }
}
