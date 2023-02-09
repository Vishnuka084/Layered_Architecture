package dao;

import model.CustomerDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO{
    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean insert(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean exist(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetailDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Boolean Update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
//    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean insert(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//            return SQLUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
//    }
//
//    @Override
//    public Boolean exist(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public OrderDetailDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean delete(String s) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public Boolean Update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public String generateNewId() throws SQLException, ClassNotFoundException {
//        return null;
//    }

}
