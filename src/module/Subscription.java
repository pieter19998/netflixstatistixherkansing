package module;

public class Subscription {

    private String email;
    private String firstname;
    private String lastname;
    private String street;
    private String housennumber;
    private String city;

    public Subscription(String email , String firstname, String lastname, String street, String housennumber, String city) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.housennumber = housennumber;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousennumber() {
        return housennumber;
    }

    public void setHousennumber(String housennumber) {
        this.housennumber = housennumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Subscription:" + '\n' +
                "email= " + email + '\n' +
                "firstname= " + firstname + '\n' +
                "lastname= " + lastname + '\n' +
                "street="  + street + '\n' +
                "housenumber= " + housennumber + '\n' +
                "city= " + city;
    }
}
