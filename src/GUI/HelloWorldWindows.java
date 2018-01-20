package GUI;

import Application.HelloWorld;
import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldWindows extends JFrame implements ActionListener {

    private static String text = "";

//getters setters
    public static String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // constructeurs
    /*
    public HelloWorldWindows() throws HeadlessException {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("wesh exercie 1 maggle");
        System.out.println(helloWorld.getTexte());
        System.out.println(text);
        text = helloWorld.getTexte();
        System.out.println(text);

    }
    */

    public HelloWorldWindows(UserWindows userWindows) {
        HelloWorld helloWorld = new HelloWorld();
        text = helloWorld.getTexte();
        windowsExercice1(userWindows);
    }


// set les parametres
    private void windowsExercice1(UserWindows userWindows){
        userWindows.setTitle("Exercice 1");
        userWindows.setContentPane(buildEx1Content(userWindows));
        userWindows.setVisible(true);
    }


    public static   JPanel buildEx1Content(UserWindows userWindows){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");

        JLabel label1 = new JLabel(getText());

        container.add(boutonRetour);
        container.add(label1);

        boutonRetour.addActionListener(userWindows::retourHome);

        return container;
    }



    public void actionPerformed1(ActionEvent e) {
        System.out.println("coucoutavu");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


}
