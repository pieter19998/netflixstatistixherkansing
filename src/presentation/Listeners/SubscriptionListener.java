package presentation.Listeners;

import dbconnection.SubscriptionRepository;
import presentation.Layouts.SubscriptionLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscriptionListener implements ActionListener {

    private SubscriptionLayout subscriptionLayout;
    private SubscriptionRepository subscriptionRepository;
    private String action = null;

    public SubscriptionListener(SubscriptionLayout subscriptionLayout, SubscriptionRepository subscriptionRepository , String action) {
        this.subscriptionLayout = subscriptionLayout;
        this.subscriptionRepository = subscriptionRepository;
        this.action = action;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (action.equals("list")) {
            JComboBox cb = (JComboBox) actionEvent.getSource();
            String x = String.valueOf(cb.getSelectedItem());
            subscriptionLayout.updateScreen(subscriptionRepository, x);
        }
        else if (action.equals("Create"))
        {
            System.out.println("CREATE");
            subscriptionLayout.createSubscription(subscriptionRepository);
        }

        else if (action.equals("Delete"))
        {
            subscriptionRepository.delete(subscriptionLayout.getMail());
        }

        else if (action.equals("Update"))
        {

        }
    }
}
