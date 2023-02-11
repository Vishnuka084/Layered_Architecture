package dao;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,RIDER,VEHICALE,ORDERDETAILS,QUERYDAO
    }

    public void getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return;
            case ITEM:
                return;
            case ORDER:
                return;
            case ORDERDETAILS:
                return;
            case RIDER:
                return;
            case VEHICALE:
                return;
            case QUERYDAO:
                return;
            default:
                return;
        }
    }


}
