import jdbcConnection.GetFromDB;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        GetFromDB getFromDB = new GetFromDB();
        System.out.println(getFromDB.getTheRichestUser());
        System.out.println(getFromDB.getSumOfAllTheAccounts());
    }
}
