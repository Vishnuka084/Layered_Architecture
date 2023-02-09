package dao;

import db.DBConnection;
import model.RiderDTO;

import java.sql.*;
import java.util.ArrayList;

public interface RiderDAO {

    ArrayList<RiderDTO> getAllRiders() throws SQLException, ClassNotFoundException ;

    boolean insertRider(RiderDTO riderDTO) throws SQLException, ClassNotFoundException ;

    Boolean existCustomer(String rid) throws SQLException, ClassNotFoundException ;

    boolean delete(String rid) throws SQLException, ClassNotFoundException ;


    Boolean Update(RiderDTO riderDTO) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
