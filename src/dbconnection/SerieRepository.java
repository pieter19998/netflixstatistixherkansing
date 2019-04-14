package dbconnection;

import module.Episode;
import module.Serie;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SerieRepository {
    
    private SqlConnection sqlConnection;

    public SerieRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Serie> readAll() {
        ArrayList<Serie> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Serie");
            while (rs.next()) {
                list.add(new Serie(rs.getString("seriename"), rs.getInt("amountofseasons"), rs.getInt("agegroup"), rs.getString("language"),rs.getInt("serieID")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Serie read(String seriename) {
        Serie Serie = null;
        try {
            String sqlQuery = "SELECT * FROM Serie WHERE seriename=" + "'" + seriename + "'";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            Serie = new Serie(rs.getString("seriename"), rs.getInt("amountofseasons"), rs.getInt("agegroup"), rs.getString("language"),rs.getInt("serieID"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Serie;
    }

    public ArrayList<Episode> getEpisodes(int serieID) {
        ArrayList<Episode> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT Episode.episodeID , Episode.episodename , Episode.episodenumber , Episode.runtime , Episode.seasonnumber , Episode.serieID\n" +
                    "FROM Serie  \n" +
                    "INNER JOIN Episode\n" +
                    "ON Serie.serieID = Episode.serieID\n" +
                    "where Serie.serieID = " + serieID +";");
            while (rs.next()) {
                list.add(new Episode(rs.getInt("episodeID"), rs.getInt("episodenumber"), rs.getInt("seasonnumber"), rs.getString("episodename"),rs.getInt("runtime")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    
}
