package presentation;

import dbconnection.SqlConnection;
import presentation.Layouts.*;

import javax.swing.*;
import java.awt.*;

public class Ui implements Runnable {

    private JFrame frame;
    private SqlConnection connection;

    public Ui(SqlConnection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        frame = new JFrame("Netflix Statistix");
        frame.setPreferredSize(new Dimension(600, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        //create Layout via Layouthandler
        container.add(new LayoutHandler(connection), BorderLayout.CENTER);


    }

    public JFrame getFrame() {
        return frame;
    }
}