package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.RiderDTO;

import java.sql.*;
import java.util.ArrayList;

public class RiderDAOImpl implements RiderDAO{

    @Override
    public ArrayList<RiderDTO> getAllRiders() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Rider");
        ArrayList<RiderDTO> allRider = new ArrayList<>();
        while (rst.next()) {
            String rid = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            allRider.add(new RiderDTO(rid, name, address));
        }
        return allRider;
    }
    @Override
    public boolean insertRider(RiderDTO riderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Rider (rid,name, address) VALUES (?,?,?)");
        pstm.setString(1, riderDTO.getRid());
        pstm.setString(2, riderDTO.getName());
        pstm.setString(3, riderDTO.getAddress());
        return pstm.executeUpdate()>0;


    }
    @Override
    public Boolean existCustomer(String rid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT rid FROM Rider WHERE rid=?");
        pstm.setString(1, rid);
        return pstm.executeQuery().next();
    }

    @Override
    public void delete(String rid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Rider WHERE rid=?");
        pstm.setString(1, rid);
        pstm.executeUpdate();
    }

    @Override
    public Boolean Update(RiderDTO riderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Rider SET name=?, address=? WHERE rid=?");
        pstm.setString(1, riderDTO.getName());
        pstm.setString(2, riderDTO.getAddress());
        pstm.setString(3, riderDTO.getRid());
        return pstm.executeUpdate()>0;
    }
    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT rid FROM Rider ORDER BY rid DESC LIMIT 1;");
        if (rst.next()) {
            String rid = rst.getString("rid");
            int newRiderId = Integer.parseInt(rid.replace("R00-", "")) + 1;
            return String.format("R00-%03d", newRiderId);
        } else {
            return "R00-001";
        }
    }
}
