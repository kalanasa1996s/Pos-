package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;
import lk.ijse.test.dao.custom.CateringDAO;
import lk.ijse.test.dto.CateringDTO;
import lk.ijse.test.entity.Catering;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CateringDAOImpl implements CateringDAO {
    @Override
    public boolean add(Catering entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Catering values(?,?,?)",entity.getCateringID(),entity.getNoOFPlate(),entity.getFoodCatagory());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("delete from Catering where cateringid=?");
    }

    @Override
    public boolean update(Catering entity) throws Exception {
        return CrudUtil.executeUpdate("update Catering set CNoOfPlate=?,CFoodCatagory=? where cateringid ",entity.getNoOFPlate(),entity.getFoodCatagory(),entity.getCateringID());
    }

    @Override
    public Catering search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Catering where cateringid=?", code);
        if (rst.next()){
            return new Catering(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            );
        }
        return null;
    }



    @Override
    public ArrayList<Catering> getall() throws SQLException, ClassNotFoundException {
        ArrayList<Catering> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from customer");
        while (rst.next()){
            company.add(new Catering(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));
        }
        return company;
    }



}
