package dbconnection;

import module.Profile;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfileRepository {
    private SqlConnection sqlConnection;

    public ProfileRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Profile> readAll() {
        ArrayList<Profile> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Profile");
            while (rs.next()) {
                list.add(new Profile(rs.getInt("profileID"), rs.getString("profilename"), rs.getDate("dateofbirth"), rs.getString("email")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Profile read(String profileName) {
        Profile Profile = null;
        try {
            String sqlQuery = "SELECT * FROM Profile WHERE profilename=" + "'" + profileName + "'";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            Profile = new Profile(rs.getInt("profileID"), rs.getString("profilename"), rs.getDate("dateofbirth"),  rs.getString("email"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Profile;
    }

    public void create(Profile Profile) {
        try {
            String sqlQuery = "INSERT INTO Profile VALUES (" + ", '" + Profile.getProfilename() + "', '" + Profile.getDateOfBirth() + ", '" + Profile.getEmail() + "')";
            sqlConnection.executeSqlNoResult(sqlQuery);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Profile Profile) {
        if (Profile == null) return;
        delete(Profile.getProfileId());
    }

    public void delete(int id) {
        try {
            String sqlQuery = "DELETE Profile WHERE profileID=" + id;
            sqlConnection.executeSqlNoResult(sqlQuery);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
