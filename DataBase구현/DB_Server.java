package games.Game13_210611;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Server {

    private static Connection Conn;

    static Connection getConnection() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://127.0.0.1/school?useSSL=false"; //127.0.0.1 <- localhost, 개인 컴퓨터
        String userid = "root";
        String userpw = "1234";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, userid, userpw);
        return conn;
    }
}
