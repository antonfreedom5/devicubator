package dao;

import entity.*;
import jdbcConnection.ConnectionDB;
import java.sql.*;
import java.util.*;

public class UserDAO implements DAO {

    private static Connection connectionDB = null;
    private static Statement statement = null;
    private static int userid;
    private static String name;
    private static String surName;
    private static List<User> userList = new ArrayList<User>();
    private static String result;

    public String getById(int id) throws SQLException {

        try{
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user where user.userid =" + id + ";");
            while (resultSet.next()){
                userid = id;
                name = resultSet.getString("name");
                surName = resultSet.getString("surName");
                result = userid + " | " + name + " " + surName;
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally {
            if (statement != null){
                statement.close();
            }
            if (connectionDB != null){
                connectionDB.close();
            }
        } return result;
    }

    public List<User> getAllUsers() throws SQLException {
        try{
            connectionDB = ConnectionDB.getConnectionDB();
            statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()){
                userid = resultSet.getInt(1);
                name = resultSet.getString("name");
                surName = resultSet.getString("surName");

                userList.add(new User(userid, name, surName));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());

        }finally {
            if (statement != null){
                statement.close();
            }
            if (connectionDB != null){
                connectionDB.close();
            }
        }
        return userList;
    }

   public List<Account> getAllAccount() throws SQLException{
        return null;
    }

}

