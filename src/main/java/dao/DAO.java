package dao;

import entity.*;
import java.sql.SQLException;
import java.util.List;

public interface DAO {

    String getById(int id) throws SQLException;

    List<Account> getAllAccount() throws SQLException;

    List<User> getAllUsers() throws SQLException;
}
