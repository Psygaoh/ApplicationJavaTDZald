package GUI;

import Application.HelloWorld;
import javafx.application.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldWindows extends JFrame implements ActionListener {

    public static   JPanel buildEx1Content(){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");




        container.add(boutonRetour);

    //   boutonRetour.addActionListener(UserWindows);

        return container;
    }

    private static void retourHome(ActionEvent actionEvent) {
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
