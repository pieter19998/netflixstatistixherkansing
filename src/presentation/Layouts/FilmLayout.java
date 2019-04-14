package presentation.Layouts;

import dbconnection.FilmRepository;
import dbconnection.SqlConnection;
import module.Film;
import presentation.Listeners.FilmListener;

import javax.swing.*;

public class FilmLayout extends JPanel {

    private SqlConnection connection;
    private JComboBox filmList;
    private JTextArea info;

    //constructor
    public FilmLayout(SqlConnection connection)
    {
        this.connection = connection;

        //create layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        FilmRepository filmRepository = new FilmRepository(connection);

        //create Jcombobox and fill with movie titles
        filmList = new JComboBox();

        for (Film film : filmRepository.readAll())
        {
            filmList.addItem(film.getFilmName());
        }

        filmList.setSelectedItem(null);
        filmList.addActionListener(new FilmListener(this , filmRepository));


        //create textarea
        info = new JTextArea();
        info.setEditable(false);

        //add to layout
        add(filmList);
        add(info);
    }

    public void setInfoText(FilmRepository filmRepository ,String filmname)
    {
        //set filmdata in infoTextArea
        Film film = filmRepository.read(filmname);
        info.setText(film.toString());
    }

    public void updateScreen(FilmRepository filmRepository , String filmname)
    {
        setInfoText(filmRepository , filmname);
    }
}
