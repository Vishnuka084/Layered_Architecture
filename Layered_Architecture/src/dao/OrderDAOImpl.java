package dao;

import model.CustomerDTO;
import model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements CrudDAO <OrderDTO,String>{


    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(OrderDTO dto) throws SQLException, ClassNotFoundException {
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
    public Boolean Update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
