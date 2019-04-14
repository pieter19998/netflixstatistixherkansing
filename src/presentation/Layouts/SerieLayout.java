package presentation.Layouts;

import dbconnection.SerieRepository;
import dbconnection.SqlConnection;
import module.Episode;
import module.Serie;
import presentation.Listeners.SeriesListener;

import javax.swing.*;
import java.awt.*;

public class SerieLayout extends JPanel {

    private SqlConnection connection;
    private JComboBox serieList;
    private JTextArea infoSerie;

    //constructor
    public SerieLayout(SqlConnection connection)
    {
        this.connection = connection;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        SerieRepository serieRepository = new SerieRepository(connection);

        //create textfield
        infoSerie = new JTextArea(5,20);
        infoSerie.setEditable(false);
        add(createSerieBox(serieRepository));
        add(infoSerie);
    }

    //creat combobox
    private JPanel createSerieBox(SerieRepository serieRepository) {
        JPanel panel = new JPanel(new GridLayout(1, 1));

        //creat combobox and loop over all available series
        panel.add(serieList = new JComboBox());

        for (Serie serie: serieRepository.readAll())
        {
            serieList.addItem(serie.getSerieName());
        }

        //set begin item item to nothing and add onclicklistener
        serieList.setSelectedItem(null);
        serieList.addActionListener(new SeriesListener(this , serieRepository));

        return panel;
    }

    public void setInfoText(SerieRepository serieRepository ,String seriename)
    {
        //create Stringbuilder to store episode data
        Serie serie= serieRepository.read(seriename);

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        //get all Episode data
        for (Episode episode : serieRepository.getEpisodes(serie.getSerieId()))
        {
            sb.append("Episodename: " + episode.getEpisodeName());
            sb.append(" Runtime: " + episode.getRuntime());
            sb.append(" Episodenumber: " + episode.getEpisodeNumber());
            sb.append(" SeasonNumber " + episode.getSeasonNumber());
            sb.append("\n");
        }

        //set text in infoTextfield
        infoSerie.setText(serie.toString() + sb.toString());
    }

    public void updateScreen(SerieRepository serieRepository, String serieName)
    {
        setInfoText(serieRepository , serieName);
    }
}
