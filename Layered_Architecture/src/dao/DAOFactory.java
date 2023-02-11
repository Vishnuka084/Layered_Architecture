package dao;

import dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    //Singleton
    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,RIDER,VEHICALE,ORDERDETAILS,QUERYDAO
    }

    //method for hide the object creation logic and return (what client want)
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();//SuperDAO superDAO =new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();//SuperDAO superDAO = new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return  new OrderDetailsDAOImpl();
            case RIDER:
                return new RiderDAOImpl();
            case VEHICALE:
                return new VehicaleDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }


}
