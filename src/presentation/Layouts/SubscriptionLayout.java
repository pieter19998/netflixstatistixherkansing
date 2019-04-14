package presentation.Layouts;

import dbconnection.SqlConnection;
import dbconnection.SubscriptionRepository;
import module.Subscription;
import presentation.Listeners.SubscriptionListener;

import javax.swing.*;
import java.awt.*;

public class SubscriptionLayout extends JPanel {

    private SqlConnection connection;
    private JComboBox subscriptionbox;
    private JTextArea info;

    //form
    private JTextField email;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField street;
    private JTextField housenumbere;
    private JTextField city;

    private JLabel emailLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel streetLabel;
    private JLabel housenumbereLabel;
    private JLabel cityLabel;

    //buttons
    private JButton create;
    private JButton update;
    private JButton delete;

    private String returnemail;


    public SubscriptionLayout(SqlConnection connection) {
        this.connection = connection;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        SubscriptionRepository subscriptionRepository = new SubscriptionRepository(connection);

        info = new JTextArea();
        info.setEditable(false);

        add(createSubscriptionbox(subscriptionRepository), BorderLayout.NORTH);
        add(info);
        add(createForm(subscriptionRepository), BorderLayout.NORTH);
        add(createMenu(subscriptionRepository), BorderLayout.SOUTH);


    }

    private JPanel createSubscriptionbox(SubscriptionRepository subscriptionRepository) {
        JPanel panel = new JPanel(new GridLayout(1, 1));

        panel.add(subscriptionbox = new JComboBox());

        for (Subscription subscription : subscriptionRepository.readAll()) {
            subscriptionbox.addItem(subscription.getEmail());
        }

        subscriptionbox.setSelectedItem(null);
        subscriptionbox.addActionListener(new SubscriptionListener(this, subscriptionRepository, "list"));

        return panel;
    }

    private JPanel createForm(SubscriptionRepository subscriptionRepository) {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(emailLabel = new JLabel("email:"));
        panel.add(panel.add(email = new JTextField()));
        panel.add(firstNameLabel = new JLabel("firstname:"));
        panel.add(firstName = new JTextField());
        panel.add(lastNameLabel = new JLabel("lastname:"));
        panel.add(lastName = new JTextField());
        panel.add(streetLabel = new JLabel("street:"));
        panel.add(street = new JTextField());
        panel.add(housenumbereLabel = new JLabel("housenumber:"));
        panel.add(housenumbere = new JTextField());
        panel.add(cityLabel = new JLabel("city:"));
        panel.add(city = new JTextField());

        return panel;
    }

    private JPanel createMenu(SubscriptionRepository subscriptionRepository) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(create = new JButton("Create"));
        panel.add(update = new JButton("Update"));
        panel.add(delete = new JButton("Delete"));

        create.addActionListener(new SubscriptionListener(this, subscriptionRepository, "Create"));
        update.addActionListener(new SubscriptionListener(this, subscriptionRepository, "Update"));
        delete.addActionListener(new SubscriptionListener(this, subscriptionRepository, "Delete"));
        return panel;
    }

    public void setInfoText(SubscriptionRepository subscriptionRepository, String email) {

        Subscription subscription = subscriptionRepository.read(email);
        int amountOfSubscriptinsConsconnected = subscriptionRepository.getAmountofConnectedAccounts(email);
        info.setText(subscription.toString() + "\n Amount of Profiles: " + amountOfSubscriptinsConsconnected);
        this.returnemail = email;
    }

    public String getMail() {
        return this.returnemail;
    }

    public void createSubscription(SubscriptionRepository subscriptionRepository) {
        Subscription subscription = new Subscription(email.getText(), firstName.getText(), lastName.getText(), street.getText(), housenumbere.getText(), city.getText());
        System.out.println(subscription.toString());
        subscriptionRepository.create(subscription);

        setInfoText(subscriptionRepository , email.getText());

        email.setText("");
        firstName.setText("");
        lastName.setText("");
        street.setText("");
        housenumbere.setText("");
        city.setText("");
    }

    public void updateScreen(SubscriptionRepository subscriptionRepository, String email) {
        setInfoText(subscriptionRepository, email);
    }

}
