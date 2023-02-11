package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
//    private final CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();
        for (Customer customer : all) {
            allCustomer.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return allCustomer;

    }
    @Override
    public boolean inserCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return  customerDAO.insert(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
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
