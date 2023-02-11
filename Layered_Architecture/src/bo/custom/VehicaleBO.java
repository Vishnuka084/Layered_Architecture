package bo.custom;

import bo.SuperBO;
import model.VehicaleDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicaleBO extends SuperBO{
    ArrayList<VehicaleDTO> getAllVehicale() throws SQLException, ClassNotFoundException ;
    boolean inserVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateVehicale(VehicaleDTO dto) throws SQLException, ClassNotFoundException;
    boolean vehicaleExite(String vid) throws SQLException, ClassNotFoundException ;
    boolean deleteVehicale(String vid) throws SQLException, ClassNotFoundException;
    String generateNewVehicaleNewID() throws SQLException, ClassNotFoundException ;
}
