package bo;

import dao.CrudDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {

    private CrudDAO<CustomerDTO,String> customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
         return customerDAO.getAll();
    }

    public boolean inserCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return  customerDAO.insert(dto);
    }
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
         return customerDAO.Update(dto);
    }
    public boolean customerExite(String id) throws SQLException, ClassNotFoundException {
         return customerDAO.exist(id);
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    public String generateNewCustomerNewID() throws SQLException, ClassNotFoundException {
         return customerDAO.generateNewId();
    }
}
