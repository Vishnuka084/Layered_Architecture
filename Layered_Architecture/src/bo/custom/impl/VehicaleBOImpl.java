package bo.custom.impl;


import bo.custom.VehicaleBO;
import dao.DAOFactory;
import dao.custom.VehicaleDAO;

import dto.VehicaleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicaleBOImpl implements VehicaleBO {
//    private final VehicaleDAO vehicaleDAO = new VehicaleDAOImpl();
      private final  VehicaleDAO vehicaleDAO = (VehicaleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICALE);

    @Override
    public ArrayList<VehicaleDTO> getAllVehicale() throws SQLException, ClassNotFoundException {
        return vehicaleDAO.getAll();
    }
    @Override
    public boolean inserVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return  vehicaleDAO.insert(dto);
    }
    @Override
    public boolean updateVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return vehicaleDAO.Update(dto);
    }
    @Override
    public boolean vehicaleExite(String vid) throws SQLException, ClassNotFoundException {
        return vehicaleDAO.exist(vid);
    }

    @Override
    public boolean deleteVehicale(String vid) throws SQLException, ClassNotFoundException {
        return vehicaleDAO.delete(vid);
    }
    @Override
    public String generateNewVehicaleNewID() throws SQLException, ClassNotFoundException {
        return vehicaleDAO.generateNewId();
    }

}
