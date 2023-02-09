package dao;

import db.DBConnection;
import model.CustomerDTO;
import model.RiderDTO;

import java.sql.*;
import java.util.ArrayList;

public class RiderDAOImpl implements CrudDAO<RiderDTO,String>{

    @Override
    public ArrayList<RiderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean exist(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean Update(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
