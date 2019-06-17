package lk.ijse.test.dao;

import lk.ijse.test.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM,CART,PAYMENT , RENT , CATERING;
    }

    public  SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return  new ItemDAOImpl();

            case CART:
                return new CartDAOImpl();

            case PAYMENT:
                return new PaymentDAOImpl();

            case RENT:
                return new RentDAOImpl();

            case CATERING:
                return new CartDAOImpl();


            default:
                return null;
        }
    }
}
