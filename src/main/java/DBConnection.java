import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null; // declare connection object
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://193.203.166.25:3306/u933391433_onlinetest", "u933391433_gurukalvi", "GuruKalvi2023");
            // conn= DriverManager.getConnection(
           // "jdbc:mysql://localhost:3306/online_exam","root", "manju12345");

           // conn = DriverManager.getConnection(
                 //   "jdbc:mysql://test-db.csse9hpx86cr.us-east-1.rds.amazonaws.com:3306/online_exam", "admin",
                   // "MySql2023");

        } catch (Exception e) {
            System.err.println("exception while creating DBConnection");
        }
        return conn;
    }

}
