package dals;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    protected Connection connection = null;
    protected String tableName = "";
    public static final String DB_NAME = "javaweb_22";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "koodinh@";
    public static final String DB_QUERY_CONNECTION = "jdbc:mysql://localhost:3306/" + DB_NAME + "?autoReconnect=true&useSSL=false";

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_QUERY_CONNECTION, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
