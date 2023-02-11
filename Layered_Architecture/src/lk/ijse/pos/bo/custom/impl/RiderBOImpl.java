package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.RIderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.RiderDAO;
import lk.ijse.pos.dto.RiderDTO;
import lk.ijse.pos.entity.Rider;

import java.sql.SQLException;
import java.util.ArrayList;

public class RiderBOImpl implements RIderBO {

    //private final RiderDAO riderDAO = new RiderDAOImpl();
     private final RiderDAO riderDAO = (RiderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RIDER);

    @Override
    public ArrayList<RiderDTO> getAllRider() throws SQLException, ClassNotFoundException {
        ArrayList<Rider> all = riderDAO.getAll();
        ArrayList<RiderDTO> allRiders = new ArrayList<>();
        for (Rider rider : all) {
            allRiders.add(new RiderDTO(rider.getRid(),rider.getName(),rider.getAddress()));

        }
        return allRiders;
    }
    @Override

    public boolean inserRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return  riderDAO.insert(new Rider(dto.getRid(),dto.getName(),dto.getAddress()));
    }
    @Override
    public boolean updateRider(RiderDTO dto) throws SQLException, ClassNotFoundException {
        return riderDAO.Update(new Rider(dto.getRid(),dto.getName(),dto.getAddress()));
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
