package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.VehicaleDTO;

import java.sql.*;
import java.util.ArrayList;

public class VehicaleDAOImpl {

    public ArrayList<VehicaleDTO> getAllVehicales() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Vehical");
        ArrayList<VehicaleDTO> allVehicales = new ArrayList<>();
        while (rst.next()) {
            String vid = rst.getString(1);
            String name = rst.getString(2);
            String colour = rst.getString(3);
            allVehicales.add(new VehicaleDTO(vid, name, colour));
        }
        return allVehicales;
    }
    public boolean insertVehicale(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Vehicale (vid,name, colour) VALUES (?,?,?)");
        pstm.setString(1, vehicaleDTO.getVid());
        pstm.setString(2, vehicaleDTO.getName());
        pstm.setString(3, vehicaleDTO.getColour());
        return pstm.executeUpdate()>0;


    }
    public Boolean existVehicale(String vid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT vid FROM Vehicale WHERE vid=?");
        pstm.setString(1, vid);
        return pstm.executeQuery().next();
    }

    public void delete(String vid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Vehicale WHERE vid=?");
        pstm.setString(1, vid);
        pstm.executeUpdate();
    }

    public Boolean Update(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Vehicale SET name=?, colour=? WHERE vid=?");
        pstm.setString(1, vehicaleDTO.getName());
        pstm.setString(2, vehicaleDTO.getColour());
        pstm.setString(3, vehicaleDTO.getVid());
        return pstm.executeUpdate()>0;
    }
    public  String generateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT vid FROM Vehicale ORDER BY vid DESC LIMIT 1;");
        if (rst.next()) {
            String vid = rst.getString("vid");
            int newVehicaleId = Integer.parseInt(vid.replace("V00-", "")) + 1;
            return String.format("V00-%03d", newVehicaleId);
        } else {
            return "V00-001";
        }
    }

}
