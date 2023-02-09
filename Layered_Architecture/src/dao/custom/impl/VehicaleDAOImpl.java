package dao.custom.impl;

import dao.custom.VehicaleDAO;

import model.VehicaleDTO;

import java.sql.*;
import java.util.ArrayList;

public class VehicaleDAOImpl implements VehicaleDAO {
    @Override
    public ArrayList<VehicaleDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean exist(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public VehicaleDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean Update(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
//
//    @Override
//    public ArrayList<VehicaleDTO> getAll() throws SQLException, ClassNotFoundException {
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
//    public boolean insert(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException {
//          return SQLUtil.executeUpdate("INSERT INTO Vehicale (vid,name, colour) VALUES (?,?,?)",vehicaleDTO.getVid(),vehicaleDTO.getName(),vehicaleDTO.getColour());
//    }
//
//    @Override
//    public Boolean exist(String vid) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("SELECT vid FROM Vehicale WHERE vid=?", vid);
//        return rst.next();
//    }
//
//    @Override
//    public VehicaleDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
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
