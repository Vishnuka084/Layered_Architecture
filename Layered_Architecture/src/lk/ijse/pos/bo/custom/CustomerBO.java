package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    boolean inserCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    boolean customerExite(String id) throws SQLException, ClassNotFoundException ;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNewCustomerNewID() throws SQLException, ClassNotFoundException ;

}
