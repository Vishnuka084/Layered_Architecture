package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import dao.DAOFactory;
import dao.custom.*;
import db.DBConnection;
import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl  implements PurchaseOrderBO {

    //Exposed the Object creation logic
    private final CustomerDAO customerDAO =(CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO =(ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO =(OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO =(OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final QueryDAO queryDAO =(QueryDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        // transaction
            Connection connection = DBConnection.getDbConnection().getConnection();
            if (orderDAO.exist(dto.getOrderId())) {

            }
            connection.setAutoCommit(false);
            boolean insert = orderDAO.insert(new Orders(dto.getOrderId(), dto.getOrderDate(),dto.getCustomerId()));

            if (insert) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : dto.getOrderDetails()) {
                boolean insert1 = orderDetailsDAO.insert(new OrderDetails(detail.getOid(),detail.getItemCode(),detail.getQty(),detail.getUnitPrice()));

                if (insert1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                ItemDTO item = searchItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                Boolean update = this.itemDAO.Update(new Item(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice()));

                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
 //       return false;
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer ent = customerDAO.search(id);
        return new CustomerDTO(ent.getId(),ent.getName(),ent.getAddress());
    }
    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        Item ent = itemDAO.search(code);
        return new ItemDTO(ent.getCode(),ent.getDescription(),ent.getUnitPrice(),ent.getQtyOnHand());

    }
    @Override
    public boolean checkItemsIsAvailabel(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }
    @Override
    public boolean checkCustomerIsAvailabel(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public String generateNewOrderID() throws SQLException, ClassNotFoundException {
       return orderDAO.generateNewId();
    }
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomer =new ArrayList<>();
        for (Customer ent : all) {
            allCustomer.add(new CustomerDTO(ent.getId(),ent.getName(),ent.getAddress()));

        }
        return allCustomer;

    }
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems =new ArrayList<>();
        for (Item ent : all) {
            allItems.add(new ItemDTO(ent.getCode(),ent.getDescription(),ent.getUnitPrice(),ent.getQtyOnHand()));
        }

        return allItems;
    }
}
