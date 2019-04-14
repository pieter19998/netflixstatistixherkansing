package presentation.Listeners;

import dbconnection.ProfileRepository;
import presentation.Layouts.ProfileLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileListener implements ActionListener {

    private ProfileLayout profileLayout;
    private ProfileRepository profileRepository;
    private String action = null;

    //constructor
    public ProfileListener(ProfileLayout profileLayout, ProfileRepository profileRepository, String action) {
        this.profileLayout = profileLayout;
        this.profileRepository = profileRepository;
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //check whitch button is clicked
        if (action.equals("list")) {
            JComboBox cb = (JComboBox) actionEvent.getSource();
            String x = String.valueOf(cb.getSelectedItem());

            profileLayout.updateScreen(profileRepository, x);
        }
        //create new profile
        else if (action.equals("Create"))
        {
            System.out.println("CREATE");
            profileLayout.createProfile(profileRepository);
        }

        //delete subscription
        else if (action.equals("Delete"))
        {
//            profileRepository.delete());
        }

        else if (action.equals("Update"))
        {

        }

    }
}
