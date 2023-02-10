package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
         return customerDAO.getAll();
    }
    @Override
    public boolean inserCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return  customerDAO.insert(dto);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
         return customerDAO.Update(dto);
    }
    @Override
    public boolean customerExite(String id) throws SQLException, ClassNotFoundException {
         return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public String generateNewCustomerNewID() throws SQLException, ClassNotFoundException {
         return customerDAO.generateNewId();
    }
}
