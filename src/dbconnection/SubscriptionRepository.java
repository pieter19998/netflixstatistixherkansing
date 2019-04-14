package dbconnection;

import module.Subscription;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SubscriptionRepository {

    private SqlConnection sqlConnection;

    public SubscriptionRepository(SqlConnection sqlConnection) {
        this.sqlConnection = sqlConnection;
    }

    public ArrayList<Subscription> readAll() {
        ArrayList<Subscription> list = new ArrayList<>();
        try {
            ResultSet rs = sqlConnection.executeSql("SELECT * FROM Subscription");
            while (rs.next()) {
                list.add(new Subscription(rs.getString("email"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("street"), rs.getString("housenumber"), rs.getString("city")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // get single subscription data
    public Subscription read(String email) {
        Subscription subscription = null;
        try {
            String sqlQuery = "SELECT * FROM Subscription WHERE email=" + "'" + email + "'";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            subscription = new Subscription((rs.getString("email")), rs.getString("firstname"), rs.getString("lastname"), rs.getString("street"), rs.getString("housenumber"), rs.getString("city"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return subscription;
    }

    public void create(Subscription subscription) {
        try {
            System.out.println(subscription.toString());
            String sqlQuery = "INSERT INTO Subscription VALUES ( '" + subscription.getEmail() + "', '" +  subscription.getFirstname() + "', '" + subscription.getLastname() + "', '" + subscription.getStreet() + "', '"+ subscription.getHousennumber() + "', '"+ subscription.getCity() + "');";
            sqlConnection.executeSql(sqlQuery);
            System.out.println(sqlQuery);
        }
        catch (Exception e) {

            System.out.println(e);
        }
    }

    //delete subscription via email
    public void delete(String email) {
        try {
            System.out.println(email);
            String sqlQuery = "DELETE Subscription WHERE email=" + "'" + email + "'" ;
            sqlConnection.executeSql(sqlQuery);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    //get the accounts under this profile
    public int getAmountofConnectedAccounts(String email) {
        int amount = 0;
        try {
            String sqlQuery = "SELECT COUNT(*) AS number\n" +
                    "FROM Subscription\n" +
                    "INNER JOIN Profile\n" +
                    "ON Subscription.email = Profile.email\n" +
                    "where Subscription.email = '" + email + "';";
            ResultSet rs = sqlConnection.executeSql(sqlQuery);
            rs.next();
            amount = rs.getInt("number");
        } catch (Exception e) {
            System.out.println(e);
        }
        return amount;
    }
}
