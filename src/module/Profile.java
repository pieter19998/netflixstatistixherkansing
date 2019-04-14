package module;

import java.util.Date;

public class Profile {

    private String profilename;
    private Date dateOfBirth;
    private String email;
    private int profileId;

    public Profile(String profilename, Date dateOfBirth , String email) {
        this.profilename = profilename;
        this.dateOfBirth = dateOfBirth;
        this.email= email;
        this.profileId = 0;
    }

    public Profile(int profileId ,String profilename, Date dateOfBirth , String email) {
        this.profilename = profilename;
        this.dateOfBirth = dateOfBirth;
        this.email= email;
        this.profileId = profileId;
    }

    public int getProfileId() {
        return profileId;
    }

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "profilename= " + profilename + "\n" +
                "dateOfBirth= " + dateOfBirth + "\n" +
                "email= " + email;
    }
}