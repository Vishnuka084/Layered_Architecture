package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.VehicaleDTO;

import java.sql.*;
import java.util.ArrayList;

public class VehicaleDAOImpl implements CrudDAO{
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
//
//    @Override
//    public ArrayList<VehicaleDTO> getAllVehicales() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Vehical");
//        ArrayList<VehicaleDTO> allVehicales = new ArrayList<>();
//        while (rst.next()) {
//            String vid = rst.getString(1);
//            String name = rst.getString(2);
//            String colour = rst.getString(3);
//            allVehicales.add(new VehicaleDTO(vid, name, colour));
//        }
//        return allVehicales;
//    }
//    @Override
//    public boolean insertVehicale(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException {
//          return SQLUtil.executeUpdate("INSERT INTO Vehicale (vid,name, colour) VALUES (?,?,?)",vehicaleDTO.getVid(),vehicaleDTO.getName(),vehicaleDTO.getColour());
//    }
//
//    @Override
//    public Boolean existVehicale(String vid) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT vid FROM Vehicale WHERE vid=?", vid);
//        return rst.next();
//    }
//
//    @Override
//    public boolean delete(String vid) throws SQLException, ClassNotFoundException {
//           return SQLUtil.executeUpdate("DELETE FROM Vehicale WHERE vid=?",vid);
//    }
//
//    @Override
//    public Boolean Update(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException {
//        return SQLUtil.executeUpdate("UPDATE Vehicale SET name=?, colour=? WHERE vid=?",vehicaleDTO.getName(),vehicaleDTO.getColour(), vehicaleDTO.getVid());
//    }
//
//    @Override
//    public  String generateNewId() throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        ResultSet rst = connection.createStatement().executeQuery("SELECT vid FROM Vehicale ORDER BY vid DESC LIMIT 1;");
//        ResultSet rst = SQLUtil.executeQuery("SELECT vid FROM Vehicale ORDER BY vid DESC LIMIT 1;");
//
//        if (rst.next()) {
//            String vid = rst.getString("vid");
//            int newVehicaleId = Integer.parseInt(vid.replace("V00-", "")) + 1;
//            return String.format("V00-%03d", newVehicaleId);
//        } else {
//            return "V00-001";
//        }
//    }

}
