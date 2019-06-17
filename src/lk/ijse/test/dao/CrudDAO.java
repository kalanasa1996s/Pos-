package lk.ijse.test.dao;


import lk.ijse.test.dao.SuperDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID> extends SuperDAO {

    public boolean add(T entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public boolean update(T entity) throws Exception;

    public T search(ID code)throws ClassNotFoundException,SQLException;

    public ArrayList<T> getall() throws SQLException, ClassNotFoundException;


}
