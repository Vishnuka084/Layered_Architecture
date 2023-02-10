package bo;

import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.CustomerDTO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    private final ItemDAO itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public boolean inserItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return  itemDAO.insert(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Update(dto);
    }
    public boolean itemExite(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }
    public String generateNewItemNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
}
