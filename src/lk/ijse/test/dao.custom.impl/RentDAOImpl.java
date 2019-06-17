package lk.ijse.test.dao.custom.impl;

import lk.ijse.test.dao.CrudUtil;
import lk.ijse.test.dao.custom.RentDAO;
import lk.ijse.test.entity.Rent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDAOImpl implements RentDAO {


    @Override
    public boolean add(Rent entity) throws Exception {
        return CrudUtil.executeUpdate("insert into Rent values(?,?,?)",entity.getRentID(),entity.getRentName(),entity.getRentDate());
    }

    @Override
    public boolean delete(String id) throws Exception {

        return CrudUtil.executeUpdate("delete from Rent where rentid=?", id);
    }

    @Override
    public boolean update(Rent entity) throws Exception {
        return  CrudUtil.executeUpdate("update Rent set rentid=?, rentname=?,rentaddress=?",entity.getRentID(),entity.getRentName(),entity.getRentDate());

    }

    @Override
    public Rent search(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from Rent where renttID=?", code);
        if (rst.next()){
            return new Rent(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            );
        }
        return null;
    }

    @Override
    public ArrayList<Rent> getall() throws SQLException, ClassNotFoundException {

        ArrayList<Rent> company =new ArrayList<>();
        ResultSet rst =CrudUtil.executeQuery("Select * from Rent");
        while (rst.next()){
            company.add(new Rent(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)

            ));

        }
        return company;
    }
}
