package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.VehicaleDAO;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Vehicale;

import java.sql.*;
import java.util.ArrayList;

public class VehicaleDAOImpl implements VehicaleDAO {
    @Override
    public ArrayList<Vehicale> getAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Vehical");
        ArrayList<Vehicale> allVehicales = new ArrayList<>();
        while (rst.next()) {
            String vid = rst.getString(1);
            String name = rst.getString(2);
            String colour = rst.getString(3);
            allVehicales.add(new Vehicale(vid, name, colour));
        }
        return allVehicales;
    }
    @Override
    public boolean insert(Vehicale vehicaleDTO) throws SQLException, ClassNotFoundException {
          return SQLUtil.executeUpdate("INSERT INTO Vehicale (vid,name, colour) VALUES (?,?,?)",vehicaleDTO.getVid(),vehicaleDTO.getName(),vehicaleDTO.getColour());
    }

    @Override
    public Boolean exist(String vid) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT vid FROM Vehicale WHERE vid=?", vid);
        return rst.next();
    }

    @Override
    public Vehicale search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String vid) throws SQLException, ClassNotFoundException {
           return SQLUtil.executeUpdate("DELETE FROM Vehicale WHERE vid=?",vid);
    }

    @Override
    public Boolean Update(Vehicale entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Vehicale SET name=?, colour=? WHERE vid=?",entity.getName(),entity.getColour(), entity.getVid());
    }

    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT vid FROM Vehicale ORDER BY vid DESC LIMIT 1;");

        if (rst.next()) {
            String vid = rst.getString("vid");
            int newVehicaleId = Integer.parseInt(vid.replace("V00-", "")) + 1;
            return String.format("V00-%03d", newVehicaleId);
        } else {
            return "V00-001";
        }
    }

}
