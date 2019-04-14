import dbconnection.*;
import module.*;
import presentation.Ui;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //start connection with sql
        SqlConnection connection = new SqlConnection();
        connection.connectDatabase("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=netflixstatistixs;integratedSecurity=true;");

        //start interface
        Ui userinterface = new Ui(connection);
        SwingUtilities.invokeLater(userinterface);


    }
}
