package bo;

import dao.CrudDAO;
import dao.custom.RiderDAO;
import dao.custom.impl.RiderDAOImpl;
import model.RiderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class RiderBOImpl implements RIderBO{

    private final RiderDAO riderDAO = new RiderDAOImpl();

    @Override
    public ArrayList<RiderDTO> getAllRider() throws SQLException, ClassNotFoundException {
         return riderDAO.getAll();
    }
    @Override

    public boolean inserRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return  riderDAO.insert(dto);
    }
    @Override
    public boolean updateRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return riderDAO.Update(dto);
    }
    @Override
    public boolean riderExite(String rid) throws SQLException, ClassNotFoundException {
        return riderDAO.exist(rid);
    }
    @Override
    public boolean deleteRider(String rid) throws SQLException, ClassNotFoundException {
        return riderDAO.delete(rid);
    }
    @Override
    public String generateNewRiderNewID() throws SQLException, ClassNotFoundException {
        return riderDAO.generateNewId();
    }
}
