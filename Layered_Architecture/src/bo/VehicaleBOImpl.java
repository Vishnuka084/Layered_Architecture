package bo;


import dao.custom.VehicaleDAO;
import dao.custom.impl.VehicaleDAOImpl;

import model.VehicaleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicaleBOImpl implements VehicaleBO {
    private final VehicaleDAO vehicaleDAO = new VehicaleDAOImpl();

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
