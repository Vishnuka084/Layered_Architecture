package bo;

import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import dao.custom.impl.*;
import db.DBConnection;
import model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderBOImpl {

    private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final ItemDAO itemDAO = new ItemDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    private final QueryDAOImpl queryDAO = new QueryDAOImpl();

    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        // transaction
            Connection connection = DBConnection.getDbConnection().getConnection();
            if (orderDAO.exist(orderId)) {

            }
            connection.setAutoCommit(false);
            boolean insert = orderDAO.insert(new OrderDTO(orderId, orderDate, customerId));

            if (insert) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detail : orderDetails) {
                boolean insert1 = orderDetailsDAO.insert(detail);

                if (insert1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

               // ItemDTO item = findItem(detail.getItemCode());
                ItemDTO item = null;
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                Boolean update = this.itemDAO.Update(item);

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

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
       return customerDAO.search(id);
    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
       return  itemDAO.search(code);
    }
}
