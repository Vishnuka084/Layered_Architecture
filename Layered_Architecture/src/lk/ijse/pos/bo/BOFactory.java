package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        if (boFactory==null) {
            boFactory =new BOFactory();
        }
        return boFactory;
    }


    public SuperBO getBO(BOTypes types){
        switch (types) {
            case CUSTOMER:
                return  new CustomerBOImpl();//superbo = new CustomerBoImpl();
            case ITEM:
                return new ItemBOImpl();//ItemBo =new ItemBOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl();//PurchaseBo bo =new PurchaseBoImpl();
            case RIDER:
                return new RiderBOImpl();
            case VEHICALE:
                return new VehicaleBOImpl();
            default:
                return null;

        }

    }

    public enum BOTypes{
        CUSTOMER,ITEM,PURCHASE_ORDER,RIDER,VEHICALE
    }

}
