package lk.ijse.test.bo;

import lk.ijse.test.bo.custom.impl.*;

public class BOFactory {



        private static BOFactory boFactory;

        private BOFactory() {
        }

        public static BOFactory getInstance() {
            if (boFactory == null) {
                boFactory = new BOFactory();
            }
            return boFactory;
        }

        public enum BOTyepes {
            CUSTOMER, ITEM , CART ,PAYMENT, RENT, CATERING , ;
        }

        public SuperBO getBO(BOTyepes types) {
            switch (types) {
                case CUSTOMER:
                    return new CustomerBOImpl();
                case ITEM:
                    return new ItemBOImpl();

                case CART:
                    return new CartBOImpl();

                case PAYMENT:
                    return new PaymentBOImpl();

                case RENT:
                    return new RentBOImpl();

                case CATERING:
                    return new CateringBOImpl();


                default:
                    return null;
            }
        }

}
