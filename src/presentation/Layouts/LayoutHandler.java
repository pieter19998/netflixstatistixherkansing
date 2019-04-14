package presentation.Layouts;

import dbconnection.SqlConnection;

import javax.swing.*;
import java.awt.*;

public class LayoutHandler extends JPanel {

    private SqlConnection connection;
    public LayoutHandler(SqlConnection connection) {

        this.connection = connection;

        setLayout(new BorderLayout());
        JTabbedPane layout = new JTabbedPane();

        //create tabs
        layout.addTab("Subscription", new SubscriptionLayout(connection));
        layout.addTab("Profile", new ProfileLayout(connection));
        layout.addTab("Films", new FilmLayout(connection));
        layout.addTab("Series", new SerieLayout(connection));

        //add tabs to layout
        add(layout);
        add(new Footer(), BorderLayout.SOUTH);
    }
}
