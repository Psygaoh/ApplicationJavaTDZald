package Application;

import GUI.HelloWorldWindows;
import GUI.UserWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld extends JFrame implements ActionListener {
    private String texte = "hello le monde, non, on ne chantera pas Zazie";

    public HelloWorld(UserWindows userWindows){
        windowsExercice1(userWindows);
    }

/*

    public HelloWorld(String texte) {
        this.texte = texte;
        windowsExercice1();
    }
    */

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    private void windowsExercice1(UserWindows userWindows){
        userWindows.setTitle("Exercice 1");
        userWindows.setSize(1100, 700);
        userWindows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userWindows.setContentPane(buildEx1Content());
        userWindows.setVisible(true);

    }

    public JPanel buildEx1Content(){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");
        JLabel text = new JLabel(texte);

        container.add(text);
        container.add(boutonRetour);

        boutonRetour.addActionListener(HelloWorld::retourHome);



        return container;
    }


    private static void retourHome(ActionEvent actionEvent) {
        UserWindows userWindows = new UserWindows();
        }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

}



