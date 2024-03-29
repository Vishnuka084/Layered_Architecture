package lk.ijse.pos.dao;


import java.sql.*;
import java.util.ArrayList;

public interface CrudDAO <T,ID>extends SuperDAO{
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException ;

    boolean insert(T dto) throws SQLException, ClassNotFoundException ;

    Boolean exist(ID id) throws SQLException, ClassNotFoundException ;

    T search(ID id)throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException ;

    Boolean Update(T dto) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
