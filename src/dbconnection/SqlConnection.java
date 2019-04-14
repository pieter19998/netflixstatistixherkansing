package dbconnection;

import java.sql.*;

public class SqlConnection {

    private Connection connection = null;

    public boolean connectDatabase(String connectionUrl) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(connectionUrl);
        }
        catch(Exception e)
        {
            System.out.println(e);
            connection=null;
            return false;
        }
        return true;
    }

    public void disconnectDatabase() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            connection=null;
        }
    }

    //execute sql
    public ResultSet executeSql(String sqlQuery) {
        ResultSet rs = null;
        try
        {
            Statement statement = this.connection.createStatement();
            rs= statement.executeQuery(sqlQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }

    // execute sql if there is no result expected
    public void executeSqlNoResult(String sqlQuery) {
        try
        {
            Statement statement = this.connection.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
