package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.RiderDAO;
import dto.RiderDTO;
import entity.Rider;

import java.sql.*;
import java.util.ArrayList;

public class RiderDAOImpl implements RiderDAO {

    @Override
    public ArrayList<Rider> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Rider");
        ArrayList<Rider> allRider = new ArrayList<>();
        while (rst.next()) {
            allRider.add(new Rider(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return allRider;
    }

    @Override
    public boolean insert(Rider entity) throws SQLException, ClassNotFoundException {
         return SQLUtil.executeUpdate("INSERT INTO Rider (rid,name, address) VALUES (?,?,?)",entity.getRid(),entity.getName(),entity.getAddress());

    }

    @Override
    public Boolean exist(String rid) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT rid FROM Rider WHERE rid=?",rid);
        return rst.next();
    }

    @Override
    public Rider search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String rid) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Rider WHERE rid=?",rid);
    }

    @Override
    public Boolean Update(Rider entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Rider SET name=?, address=? WHERE rid=?",entity.getName(),entity.getAddress(),entity.getRid());
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT rid FROM Rider ORDER BY rid DESC LIMIT 1;");
        if (rst.next()) {
            String rid = rst.getString("rid");
            int newRiderId = Integer.parseInt(rid.replace("R00-", "")) + 1;
            return String.format("R00-%03d", newRiderId);
        } else {
            return "R00-001";
        }
    }
}
