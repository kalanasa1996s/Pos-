package lk.ijse.test.bo.custom.impl;

import lk.ijse.test.bo.custom.CateringBO;
import lk.ijse.test.dao.DAOFactory;
import lk.ijse.test.dao.custom.CartDAO;
import lk.ijse.test.dao.custom.CateringDAO;
import lk.ijse.test.dto.CateringDTO;
import lk.ijse.test.entity.Catering;

import java.sql.SQLException;
import java.util.ArrayList;

public class CateringBOImpl implements CateringBO {

    CateringDAO dao = (CateringDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATERING);

    @Override
    public boolean addCatering(CateringDTO ref) throws Exception {
        return dao.add(new Catering(ref.getCateringID(),ref.getNoOFPlate(),ref.getFoodCatagory()));
    }

    @Override
    public boolean updateCatering(CateringDTO ref) throws Exception {
        return dao.update(new Catering(ref.getCateringID(),ref.getNoOFPlate(),ref.getFoodCatagory()));
    }

    @Override
    public boolean deleteCatering(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public CateringDTO searchCatering(String code) throws ClassNotFoundException, SQLException {
        Catering search =dao.search(code);

        return new CateringDTO(search.getCateringID(),search.getNoOFPlate(),search.getFoodCatagory());
    }

    @Override
    public ArrayList<CateringDTO> getallCatering() throws SQLException, ClassNotFoundException {
        ArrayList<Catering> all=dao.getall();
        ArrayList<CateringDTO> allcus=new ArrayList<>();
        for(Catering ser:all){
            allcus.add(new CateringDTO(
                    ser.getCateringID(),
                    ser.getNoOFPlate(),
                    ser.getFoodCatagory()

            ));
        }
        return allcus;
    }
    }

