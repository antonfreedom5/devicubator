package jdbcConnection;

import jdbcConnection.ConnectionDB;

import java.sql.*;

public class GetFromDB {
    private static Connection connectionDB = null;
    private static Statement statement = null;
    private static int account;
    private static String name;
    private static String surName;
    private static String result;

    public static String getTheRichestUser() throws SQLException {

        try {
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from account, user where user.userid = account.userid and account.account=(select max(account) from account)");
            while (resultSet.next()) {
                name = resultSet.getString("name");
                surName = resultSet.getString("surName");
                account = resultSet.getInt("account");
                result = name + " " + surName + " | " + account;
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

    public static String getSumOfAllTheAccounts() throws SQLException {

        try {
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select sum(account) from account");
            while (resultSet.next()) {
                account = resultSet.getInt("sum(account)");
                result = "Sum of all the accounts is: " + account;
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
}
