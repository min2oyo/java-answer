package stage.today15.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {

    public static Connection conn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1/jcp?useSSL=false";
        String userid = "root";
        String userpw = "1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url, userid, userpw);
        return conn;
    }

    public static void dbclose() {
        try {
            conn.close();
            conn = null;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
