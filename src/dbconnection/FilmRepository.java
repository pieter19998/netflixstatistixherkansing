package dbconnection;

import module.Film;

import java.sql.*;
import java.util.*;

public class FilmRepository {
    private SqlConnection sqlConnection;

    public FilmRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    //get all films
    public ArrayList<Film> readAll() {
        ArrayList<Film> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM film");
            while(rs.next()) {
                list.add(new Film(rs.getInt("filmID"),rs.getString("filmname"), rs.getString("language"), rs.getInt("agegroup"), rs.getInt("runtime"), rs.getInt("recommended")));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //get one film
    public Film read(String filmname) {
        Film film = null;
        try
        {
            String sqlQuery = "SELECT * FROM film WHERE filmname=" + "'" + filmname + "'";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            film = new Film(rs.getInt("filmID"),rs.getString("filmname"), rs.getString("language"), rs.getInt("agegroup"), rs.getInt("runtime"), rs.getInt("recommended"));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return film;
    }
}
