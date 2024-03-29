package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.RiderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RIderBO extends SuperBO {
    ArrayList<RiderDTO> getAllRider() throws SQLException, ClassNotFoundException ;
    boolean inserRider(RiderDTO dto) throws SQLException, ClassNotFoundException ;
    boolean updateRider(RiderDTO dto) throws SQLException, ClassNotFoundException ;
    boolean riderExite(String rid) throws SQLException, ClassNotFoundException ;
    boolean deleteRider(String rid) throws SQLException, ClassNotFoundException;
    String generateNewRiderNewID() throws SQLException, ClassNotFoundException ;

}
