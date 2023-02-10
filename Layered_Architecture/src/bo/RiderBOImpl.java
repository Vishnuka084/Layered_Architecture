package bo;

import dao.CrudDAO;
import dao.custom.impl.RiderDAOImpl;
import model.CustomerDTO;
import model.RiderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RiderBOImpl {

    private CrudDAO<RiderDTO,String> riderDAO = new RiderDAOImpl();

    public ArrayList<RiderDTO> getAllRider() throws SQLException, ClassNotFoundException {
         return riderDAO.getAll();
    }

    public boolean inserRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return  riderDAO.insert(dto);
    }
    public boolean updateRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return riderDAO.Update(dto);
    }
    public boolean riderExite(String id) throws SQLException, ClassNotFoundException {
        return riderDAO.exist(id);
    }

    public boolean deleteRider(String id) throws SQLException, ClassNotFoundException {
        return riderDAO.delete(id);
    }
    public String generateNewRiderNewID() throws SQLException, ClassNotFoundException {
        return riderDAO.generateNewId();
    }
}
