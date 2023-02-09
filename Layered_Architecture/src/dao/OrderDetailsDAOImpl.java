package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements CrudDAO{
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
}
