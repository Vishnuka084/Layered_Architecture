package dao;

import db.DBConnection;
import model.VehicaleDTO;

import java.sql.*;
import java.util.ArrayList;

public interface VehicaleDAO {
    ArrayList<VehicaleDTO> getAllVehicales() throws SQLException, ClassNotFoundException ;

    boolean insertVehicale(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException ;

    Boolean existVehicale(String vid) throws SQLException, ClassNotFoundException ;

    void delete(String vid) throws SQLException, ClassNotFoundException ;

    Boolean Update(VehicaleDTO vehicaleDTO) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
