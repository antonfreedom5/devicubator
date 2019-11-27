package servlets;

import jdbcConnection.ConnectionDB;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class GetFromDateBase extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connectionDB = ConnectionDB.getConnectionDB();
            Statement statement = connectionDB.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user, account where user.userid = account.userid");

            writer.println("<!DOCTYPE html>" + "<html><head><title>" + "The List Bank" + "</title></head><body>");
            writer.println("<h1 align='center'>BANK DATA</h1>");
            writer.println("<table border='1' width='30%' align='center'><tr><th>ID</th><th>Name</th><th>SurName</th><th>Account</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String surName = resultSet.getString("surName");
                int account = resultSet.getInt("account");

                writer.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + surName + "</td><td>" + account + "</td></tr><br/>");
            }
            writer.println("</table>");

            resultSet.close();
            statement.close();
            connectionDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</body></html>");

/*        response.setContentType("text/html");
*       PrintWriter writer = response.getWriter();
*
*
*        try {
*            DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
*            DAO account = new AccountDAO();
*            List listAccount = account.getAllAccount();
*            writer.println("<html>" + Arrays.asList(listAccount) + "</html>" );
*        } catch (SQLException e) {
*            e.printStackTrace();
*        }
*    }*/

    }
}

