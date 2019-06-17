package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.RentBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.RentDAO;
import lk.ijse.test.dto.RentDTO;
import lk.ijse.test.entity.Rent;

import java.sql.SQLException;
import java.util.ArrayList;

public class RentBOImpl implements RentBO {

    RentDAO dao =(RentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RENT);

    @Override
    public boolean addItem(RentDTO item) throws Exception {
        return dao.add(new Rent(item.getRentID(),item.getRentName(),item.getRentDate()));
    }

    @Override
    public boolean updateItem(RentDTO item) throws Exception {
        return dao.update(new Rent(item.getRentID(),item.getRentName(),item.getRentDate()));
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        return  dao.delete(id);
    }

    @Override
    public RentDTO searchRent(String code) throws ClassNotFoundException, SQLException {
        Rent search = dao.search(code);
        return new RentDTO(search.getRentID(),search.getRentName(),search.getRentDate());
    }



    @Override
    public ArrayList<RentDTO> getallRent() throws SQLException, ClassNotFoundException {

        ArrayList<Rent> all=dao.getall();
        ArrayList<RentDTO> allrent=new ArrayList<>();
        for(Rent ser:all){
            allrent.add(new RentDTO(
                    ser.getRentID(),
                    ser.getRentName(),
                    ser.getRentDate()

            ));
        }
        return allrent;
    }
}
