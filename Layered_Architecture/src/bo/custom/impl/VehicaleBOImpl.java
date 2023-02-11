package bo.custom.impl;


import bo.custom.VehicaleBO;
import dao.DAOFactory;
import dao.custom.VehicaleDAO;

import dto.RiderDTO;
import dto.VehicaleDTO;
import entity.Vehicale;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehicaleBOImpl implements VehicaleBO {
//    private final VehicaleDAO vehicaleDAO = new VehicaleDAOImpl();
      private final  VehicaleDAO vehicaleDAO = (VehicaleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICALE);

    @Override
    public ArrayList<VehicaleDTO> getAllVehicale() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicale> all = vehicaleDAO.getAll();
        ArrayList<VehicaleDTO> allVehiccale = new ArrayList<>();
        for (Vehicale vehicale : all) {
            allVehiccale.add(new VehicaleDTO(vehicale.getVid(),vehicale.getName(),vehicale.getColour()));

        }
        return allVehiccale;

    }
    @Override
    public boolean inserVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return  vehicaleDAO.insert(new Vehicale(dto.getVid(),dto.getName(), dto.getColour()));
    }
    @Override
    public boolean updateVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException {
        return vehicaleDAO.Update(new Vehicale(dto.getVid(),dto.getName(), dto.getColour()));
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
