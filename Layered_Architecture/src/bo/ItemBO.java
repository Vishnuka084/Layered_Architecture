package bo;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {

    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    boolean inserItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean itemExite(String id) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    String generateNewItemNewID() throws SQLException, ClassNotFoundException;

}
