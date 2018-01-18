package Application;

import GUI.HelloWorldWindows;
import GUI.UserWindows;

import javax.swing.*;

public class HelloWorld extends JFrame{
    private String texte = "hello le monde";

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
        userWindows.setContentPane(HelloWorldWindows.buildEx1Content());
        userWindows.setVisible(true);

    }





}
