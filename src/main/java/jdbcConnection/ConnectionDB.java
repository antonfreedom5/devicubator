package jdbcConnection;
import java.sql.*;

public class ConnectionDB {

    private static final String PATH = "jdbc:mysql://localhost/thebanklist?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnectionDB(){
        Connection connectionDB = null;
        try{
            connectionDB = DriverManager.getConnection(PATH, USER, PASSWORD);
            return connectionDB;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connectionDB;
    }
}
