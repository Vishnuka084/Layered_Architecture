package bo.custom;

import model.RiderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RIderBO {
    ArrayList<RiderDTO> getAllRider() throws SQLException, ClassNotFoundException ;
    boolean inserRider(RiderDTO dto) throws SQLException, ClassNotFoundException ;
    boolean updateRider(RiderDTO dto) throws SQLException, ClassNotFoundException ;
    boolean riderExite(String rid) throws SQLException, ClassNotFoundException ;
    boolean deleteRider(String rid) throws SQLException, ClassNotFoundException;
    String generateNewRiderNewID() throws SQLException, ClassNotFoundException ;

}
