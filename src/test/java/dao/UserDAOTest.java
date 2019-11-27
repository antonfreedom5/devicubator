package dao;

import entity.User;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    @Test
    public void getById() throws SQLException {
        DAO user = new UserDAO();
        String actual = "2 | Artur Bustrov";
        String expected = user.getById(2);
        assertEquals(actual, expected);
    }

    @Test
    public void getAllUsers() throws SQLException {
        DAO user = new UserDAO();
        List userList = user.getAllUsers();
        int actual = 11;
        int expected = userList.size();
        assertEquals(actual, expected);
    }
}