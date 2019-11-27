<%--
  Created by IntelliJ IDEA.
  User: antonfreedom5
  Date: 25.11.2019
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jdbcConnection.GetFromDB" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <title>Bank info</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <th>The richest user</th>
            <th>The sum of all the accounts</th>
        </tr>
        <tr>
            <td><% try {%><%= out.print(GetFromDB.getTheRichestUser()) %> <%}catch (SQLException e){e.getStackTrace();}%></td>
            <td><% try {%><%= out.print(GetFromDB.getSumOfAllTheAccounts()) %> <%}catch (SQLException e){e.getStackTrace();}%></td>
        </tr>
        <tr>
            <td><button>Get</button></td>
            <td><button>Get</button></td>
        </tr>
    </table>
</body>
</html>
