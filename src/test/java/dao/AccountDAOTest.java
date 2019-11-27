package dao;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AccountDAOTest {

    @org.junit.Test
    public void getById() throws SQLException {
        DAO account = new AccountDAO();
        String actual = "2 | 234";
        String expected = account.getById(2);
        assertEquals(actual, expected);
    }

    @org.junit.Test
    public void getAllUsers() throws SQLException {
        DAO account = new AccountDAO();
        List accountList = account.getAllAccount();
        int actual = 11;
        int expected = accountList.size();
        assertEquals(actual, expected);
    }
}