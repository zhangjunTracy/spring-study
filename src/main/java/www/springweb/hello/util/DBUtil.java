package www.springweb.hello.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/zhangtracy?autoReconnect=true&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static void execute(List<String> staticList) {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        for (String staticsql : staticList) {

            try {
                dbConnection = getDBConnection();
                preparedStatement = dbConnection.prepareStatement(staticsql);
                try {
                    preparedStatement.execute();
                } catch (SQLException e) {
                    System.out.println(staticsql);
                    System.out.println(e.getMessage());

                } finally {

                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }

                    if (dbConnection != null) {
                        dbConnection.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static List<Map<String, Object>> query(String querySQL) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {

            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(querySQL);
            rs = preparedStatement.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }
            return list;
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;

    }

    public static Connection getDBConnection() {

        Connection dbConnection = null;

        
          try {
          
          Class.forName(DB_DRIVER);
          
          } catch (ClassNotFoundException e) {
          
          System.out.println(e.getMessage());
          
          }
         

        try {

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}
