package dao;


import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CrudDAO {
    ArrayList<Object> getAll() throws SQLException, ClassNotFoundException ;

    boolean insert(Object dto) throws SQLException, ClassNotFoundException ;

    Boolean exist(Object id) throws SQLException, ClassNotFoundException ;

    boolean delete(Object id) throws SQLException, ClassNotFoundException ;

    Boolean Update(Object dto) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
