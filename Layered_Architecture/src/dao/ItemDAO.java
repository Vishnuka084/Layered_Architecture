package dao;

import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    boolean delete(String code) throws SQLException, ClassNotFoundException ;

    boolean insertItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    Boolean Update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    Boolean existItems(String code) throws SQLException, ClassNotFoundException ;

    String generateNewId() throws SQLException, ClassNotFoundException ;

}
