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


// constructeur
    public HelloWorldWindows(UserWindows userWindows) {
        HelloWorld helloWorld = new HelloWorld();
        text = helloWorld.getTexte();
        windowsExercice1(userWindows);
    }


// set les parametres de la fentre
    private void windowsExercice1(UserWindows userWindows){
        userWindows.setTitle("Exercice 1");
        userWindows.setContentPane(buildEx1Content(userWindows));
        userWindows.setVisible(true);
    }

// créé les nouveaux elements nécessaire
    public static   JPanel buildEx1Content(UserWindows userWindows){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");

        JPanel panelTitre = new JPanel();
        JPanel panelContenuMargin = new JPanel();
        JPanel panelContenu = new JPanel();
        JPanel espace = new JPanel();
        JPanel espaceH = new JPanel();
        JLabel labelTitre = new JLabel("Exercice 1");
        JLabel label1 = new JLabel(getText());


        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelContenu);

        panelTitre.add(boutonRetour);
        panelTitre.add(labelTitre);
        panelContenu.add(label1);


        label1.setFont(new Font("Serif", Font.BOLD, 40));
        labelTitre.setFont(new Font("Serif", Font.BOLD, 40));

        // du panel
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        panelContenu.setLayout(new GridLayout(4, 1, 20, 30));


        // les couleurs
        panelTitre.setBackground(Color.CYAN);
        panelContenuMargin.setBackground(Color.LIGHT_GRAY);
        espace.setBackground(Color.LIGHT_GRAY);
        espaceH.setBackground(Color.LIGHT_GRAY);
        panelContenu.setBackground(Color.PINK);


        // la taille
        panelContenu.setPreferredSize(new Dimension(800, 540));
        espaceH.setPreferredSize(new Dimension(1200,10));
        espace.setPreferredSize(new Dimension(1200,15));

        // du bouton



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
