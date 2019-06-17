package lk.ijse.test.bo.custom;

import lk.ijse.test.bo.SuperBO;
import lk.ijse.test.dto.CateringDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CateringBO  extends SuperBO {

    public boolean addCatering(CateringDTO ref) throws Exception;

    public boolean updateCatering(CateringDTO ref) throws Exception;

    public boolean deleteCatering(String id) throws Exception;

    public CateringDTO searchCatering(String code) throws ClassNotFoundException, SQLException;

    public ArrayList<CateringDTO> getallCatering() throws SQLException, ClassNotFoundException;


}
