package lk.ijse.pos.bo.custom.impl;


import lk.ijse.pos.bo.custom.VehicaleBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.VehicaleDAO;

import lk.ijse.pos.dto.VehicaleDTO;
import lk.ijse.pos.entity.Vehicale;

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
