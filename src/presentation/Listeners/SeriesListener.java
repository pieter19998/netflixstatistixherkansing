package presentation.Listeners;

import dbconnection.SerieRepository;
import dbconnection.SqlConnection;
import presentation.Layouts.SerieLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeriesListener implements ActionListener {

    private SerieLayout serieLayout;
    private SerieRepository serieRepository;

    public SeriesListener(SerieLayout serieLayout, SerieRepository serieRepository) {
        this.serieLayout = serieLayout;
        this.serieRepository = serieRepository;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JComboBox cb = (JComboBox)actionEvent.getSource();

        String x = String.valueOf(cb.getSelectedItem());

        serieLayout.updateScreen(serieRepository ,x);

    }
}
