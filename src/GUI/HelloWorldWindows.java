package GUI;

import javax.swing.*;

public class HelloWorldWindows {

    public static JPanel buildEx1Content(){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");


        container.add(boutonRetour);
        return container;
    }
}
