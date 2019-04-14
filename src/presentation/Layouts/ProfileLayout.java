package presentation.Layouts;

import dbconnection.ProfileRepository;
import dbconnection.SqlConnection;
import module.Profile;
import presentation.Listeners.ProfileListener;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProfileLayout extends JPanel {

    private SqlConnection connection;
    private JComboBox connectedProfiles;
    private JTextArea info;

    //form
    private JTextField profileName;
    private JTextField dateOfBirth;
    private JTextField email;

    private JLabel profileNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel emailLabel;

    //buttons
    private JButton create;
    private JButton update;
    private JButton delete;

    private String returnemail;

    //constructor
    public ProfileLayout(SqlConnection connection){
        //set connection
        this.connection = connection;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


        ProfileRepository profileRepository = new ProfileRepository(connection);

        //create textfield
        info = new JTextArea();
        info.setEditable(false);

        //add panels to layout
        add(createProfileBox(profileRepository), BorderLayout.NORTH);
        add(info);
        add(createForm(profileRepository), BorderLayout.NORTH);
        add(createMenu(profileRepository), BorderLayout.SOUTH);


    }

    //creat combobox
    private JPanel createProfileBox(ProfileRepository profileRepository) {
        JPanel panel = new JPanel(new GridLayout(1, 1));

        //creat combobox and loop over all available profiles
        panel.add(connectedProfiles = new JComboBox());

        for (Profile profile : profileRepository.readAll()) {
            connectedProfiles.addItem(profile.getProfilename());
        }

        //set begin item item to nothing and add onclicklistener
        connectedProfiles.setSelectedItem(null);
        connectedProfiles.addActionListener(new ProfileListener(this, profileRepository, "list"));

        return panel;
    }

    private JPanel createForm(ProfileRepository profileRepository) {
        //create form for create function
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(profileNameLabel = new JLabel("profileName:"));
        panel.add(panel.add(profileName = new JTextField()));
        panel.add(emailLabel = new JLabel("Email:"));
        panel.add(email = new JTextField());
        panel.add(dateOfBirthLabel = new JLabel("DateOfBirth: year/month/day "));
        panel.add(dateOfBirth = new JTextField());

        return panel;
    }

    private JPanel createMenu(ProfileRepository profileRepository) {
        //create footer menu and add to the panel
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(create = new JButton("Create"));
        panel.add(update = new JButton("Update"));
        panel.add(delete = new JButton("Delete"));

        create.addActionListener(new ProfileListener(this, profileRepository, "Create"));
        update.addActionListener(new ProfileListener(this, profileRepository, "Update"));
        delete.addActionListener(new ProfileListener(this, profileRepository, "Delete"));
        return panel;
    }

    public void setInfoText(ProfileRepository profileRepository, String profileName) {


        Profile profile = profileRepository.read(profileName);
        //set profiledata in info textarea
        info.setText(profile.toString());
    }

    public void createProfile(ProfileRepository profileRepository) {

        //convert string to time
        DateFormat format = new SimpleDateFormat("yyyy MMMM d ", Locale.ENGLISH);
        setInfoText(profileRepository , email.getText());

        //empty form after delete
        profileName.setText("");
        email.setText("");
        dateOfBirth.setText("");
    }

    //send data to info textarea
    public void updateScreen(ProfileRepository profileRepository, String profileName) {
        setInfoText(profileRepository, profileName);
    }

}
