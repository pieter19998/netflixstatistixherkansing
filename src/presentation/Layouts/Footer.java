package presentation.Layouts;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel{

    public Footer() {
        //create footer
        setLayout(new BorderLayout());
        JLabel watermark = new JLabel("Informatica 23IVT1B - Pieter Mourik");
        add(watermark);
    }
}
