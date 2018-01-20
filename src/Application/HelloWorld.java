package Application;

import GUI.HelloWorldWindows;
import GUI.UserWindows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld extends JFrame /*implements ActionListener*/ {

    private static String texte = "HELLO WORLD";


    public HelloWorld() throws HeadlessException {
    }



    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

}



