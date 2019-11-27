package dao;

import entity.*;
import jdbcConnection.ConnectionDB;
import java.sql.*;
import java.util.*;

public class AccountDAO implements DAO {

    private static Connection connectionDB = null;
    private static Statement statement = null;
    private static int accountid;
    private static int account;
    private static String name;
    private static String surName;
    private static List<Account> accountList = new ArrayList();
    private static String result;

    public String getById(int id) throws SQLException {

        try {
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from account where account.accountid =" + id + ";");
            while (resultSet.next()) {
                accountid = resultSet.getInt(1);
                account = resultSet.getInt(2);
                result = accountid + " | " + account;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connectionDB != null) {
                connectionDB.close();
            }
        }
        return result;
    }

    public List<Account> getAllAccount() throws SQLException {
        try {
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user, account where user.userid = account.userid");
            while (resultSet.next()) {
                accountid = resultSet.getInt(1);
                name = resultSet.getString("name");
                surName = resultSet.getString("surName");
                account = resultSet.getInt("account");

                accountList.add(new Account(accountid, name, surName, account));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connectionDB != null) {
                connectionDB.close();
            }
        }
        return accountList;
    }

   public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public String toString() {
        return accountid + " " + name + " " + surName +  " " + account;
    }
}
