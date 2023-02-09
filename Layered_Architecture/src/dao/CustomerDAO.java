package dao;


import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException ;

    boolean insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    Boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    boolean delete(String id) throws SQLException, ClassNotFoundException ;

    Boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
