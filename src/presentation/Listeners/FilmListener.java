package presentation.Listeners;

import dbconnection.FilmRepository;
import dbconnection.SqlConnection;
import module.Film;
import presentation.Layouts.FilmLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmListener implements ActionListener {

    private FilmLayout filmLayout;
    private FilmRepository filmRepository;

    public FilmListener(FilmLayout filmLayout , FilmRepository filmRepository) {
        this.filmLayout = filmLayout;
        this.filmRepository = filmRepository;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JComboBox cb = (JComboBox)actionEvent.getSource();

        String x = String.valueOf(cb.getSelectedItem());

        filmLayout.updateScreen(filmRepository ,x);

    }
}
