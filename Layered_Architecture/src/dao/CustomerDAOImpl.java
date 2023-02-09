package dao;

import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;


public class CustomerDAOImpl implements CrudDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean exist(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Customer");
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//        while (rst.next()) {
//            allCustomers.add(new CustomerDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return allCustomers;
//    }
//    @Override
//    public boolean insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//       return SQLUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
//
//    }
//
//    @Override
//    public Boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer WHERE id=?", id);
//        return rst.next();
//    }
//
//    @Override
//    public boolean delete(String id) throws SQLException, ClassNotFoundException {
//           return SQLUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
//    }
//
//    @Override
//    public Boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//         return SQLUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
//
//    }
//
//    @Override
//    public  String generateNewId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }
}
