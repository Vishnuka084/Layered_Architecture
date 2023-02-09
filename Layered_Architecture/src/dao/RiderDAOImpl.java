package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.RiderDTO;

import java.sql.*;
import java.util.ArrayList;

public class RiderDAOImpl implements CrudDAO{
    @Override
    public ArrayList<Object> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(Object dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean exist(Object id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(Object id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean Update(Object dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
//    @Override
//    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean insert(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public Boolean exist(String id) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public Boolean Update(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public String generateNewId() throws SQLException, ClassNotFoundException {
//        return null;
//    }

//    @Override
//    public ArrayList<RiderDTO> getAllRiders() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Rider");
//        ArrayList<RiderDTO> allRider = new ArrayList<>();
//        while (rst.next()) {
//            allRider.add(new RiderDTO(rst.getString(1), rst.getString(2), rst.getString(3)));
//        }
//        return allRider;
//    }
//
//    @Override
//    public boolean insertRider(RiderDTO riderDTO) throws SQLException, ClassNotFoundException {
//          return SQLUtil.executeUpdate("INSERT INTO Rider (rid,name, address) VALUES (?,?,?)",riderDTO.getRid(),riderDTO.getName(),riderDTO.getAddress());
//    }
//
//    @Override
//    public Boolean existCustomer(String rid) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT rid FROM Rider WHERE rid=?",rid);
//        return rst.next();
//    }
//
//    @Override
//    public boolean delete(String rid) throws SQLException, ClassNotFoundException {
//         return SQLUtil.executeUpdate("DELETE FROM Rider WHERE rid=?",rid);
//    }
//
//    @Override
//    public Boolean Update(RiderDTO riderDTO) throws SQLException, ClassNotFoundException {
//          return SQLUtil.executeUpdate("UPDATE Rider SET name=?, address=? WHERE rid=?",riderDTO.getName(),riderDTO.getAddress(),riderDTO.getRid());
//    }
//
//    @Override
//    public  String generateNewId() throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT rid FROM Rider ORDER BY rid DESC LIMIT 1;");
//        if (rst.next()) {
//            String rid = rst.getString("rid");
//            int newRiderId = Integer.parseInt(rid.replace("R00-", "")) + 1;
//            return String.format("R00-%03d", newRiderId);
//        } else {
//            return "R00-001";
//        }
//    }
}
