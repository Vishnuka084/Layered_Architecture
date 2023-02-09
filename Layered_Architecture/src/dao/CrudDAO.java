package dao;


import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CrudDAO {
    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException ;

    boolean insert(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    Boolean exist(String id) throws SQLException, ClassNotFoundException ;

    boolean delete(String id) throws SQLException, ClassNotFoundException ;

    Boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
