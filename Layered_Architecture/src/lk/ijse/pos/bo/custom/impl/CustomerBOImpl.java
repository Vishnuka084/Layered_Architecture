package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

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
         return customerDAO.Update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
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
