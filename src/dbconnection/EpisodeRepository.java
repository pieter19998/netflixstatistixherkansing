package dbconnection;

import module.Episode;
import module.Film;

import java.sql.ResultSet;
import java.util.ArrayList;

public class EpisodeRepository {
    private SqlConnection sqlConnection;

    // get Arraylist with all Episodes
    public EpisodeRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Episode> readAll() {
        ArrayList<Episode> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM episode");
            while(rs.next()) {
                list.add(new Episode(rs.getInt("episodeid"),rs.getInt("episodenumber"), rs.getInt("seasonnumber"), rs.getString("episodename"), rs.getInt("runtime")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //get single episode
    public Episode read(int id) {
        Episode episode = null;
        try
        {
            String sqlQuery = "SELECT * FROM episode WHERE episodeId=" + id;
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            episode = new Episode(rs.getInt("episodeid"),rs.getInt("episodenumber"), rs.getInt("seasonnumber"), rs.getString("episodename"), rs.getInt("runtime"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return episode;
    }
}
