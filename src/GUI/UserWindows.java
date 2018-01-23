package GUI;

import Application.Devinette;
import Application.HelloWorld;
import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class UserWindows extends JFrame implements ActionListener {
    int count = 0;

    //elements du GUI important
    JPanel container = new JPanel();
    JPanel panelTitre = new JPanel();
    JPanel panelContenuMargin = new JPanel();
    JPanel panelContenu = new JPanel();
    JPanel espace = new JPanel();
    JPanel espaceH = new JPanel();

    JLabel label_1 = new JLabel("welcome");
    JButton bouton_1 = new JButton("Hello World");
    JButton bouton_2 = new JButton("Devine le chiffre");
    JButton bouton_3 = new JButton("WIP |||         Concession    |||  WORK IN PROGRESS");
    JButton bouton_4 = new JButton("Calculatrice |||| TODO");


    public UserWindows() {
      //  super();
        setUp(this);
    }


    public UserWindows(UserWindows userWindows) {
        super();
        setUp(userWindows);
    }


    private void setUp(UserWindows userWindows) {
        userWindows.setTitle("Home");
        userWindows.setSize(1100, 700);
        userWindows.setResizable(false);
        userWindows.setLocationRelativeTo(null);
        userWindows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userWindows.setContentPane(buildAccueilContent(this));
        userWindows.setContentPane(addElementsAccueil(this));
        userWindows.setVisible(true);
    }

    private void setUp(HelloWorldWindows helloWorldWindows) {
        helloWorldWindows.setTitle("Mon application");
        helloWorldWindows.setSize(1100, 700);
        helloWorldWindows.setResizable(false);
        helloWorldWindows.setLocationRelativeTo(null);
        helloWorldWindows.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        helloWorldWindows.setContentPane(buildAccueilContent(this));
        helloWorldWindows.setVisible(true);
    }

    // contenu de la fenetre de base

//ajoute les differents elements dans l'ordre afin de composer l'affichage
    private JPanel addElementsAccueil(UserWindows userWindows){
    container.add(panelTitre);
    container.add(panelContenuMargin);
    panelContenuMargin.add(espaceH);
    panelContenuMargin.add(panelContenu);


    panelTitre.add(label_1);

    panelContenu.add(bouton_1);
    panelContenu.add(bouton_2);
    panelContenu.add(bouton_3);
    panelContenu.add(bouton_4);

    // listeners
    bouton_1.addActionListener(this::helloWorld);
    bouton_2.addActionListener(this::devinette);
    bouton_3.addActionListener(this::concession);

        return container;
}



    // parametreur des differents elements composant la page home
    private JPanel buildAccueilContent(UserWindows userWindows) {


        userWindows.setTitle("Home");

        //du jlabel bienvenu
        label_1.setFont(new Font("Serif", Font.BOLD, 40));

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

        bouton_1.setPreferredSize(new Dimension(200, 200));
        bouton_2.setPreferredSize(new Dimension(200, 200));

        // assemblages

        // return

        return container;
    }


// vérifie qu'il n'yait pas de boucle lors du changement de page (a supprimer)
    private void msgtest(ActionEvent actionEvent) {
        count++;
        System.out.println("test d'ajout en boucle? count ="+count);
    }



// ouvre l'exercice 1(hello wworld), et affiche la fenetre HelloWorldWindows piochant dans la classe hellowWorld

    public void helloWorld(ActionEvent e) {
         HelloWorldWindows helloWorldWindows = new HelloWorldWindows(this);
     }

// ouvre exercice 2(devinette), affiche fenetre DevinetteWindows piochant dans la classe Devinette
    private void devinette(ActionEvent e){
        DevinetteWindows devinetteWindows = new DevinetteWindows(this);

    }
// ouvre la concession
    private void concession(ActionEvent actionEvent) {
        ConcessionWindows concessionWindows = new ConcessionWindows(this);
    }
// sert de test le onclick
    public void actionPerformed1(ActionEvent e) {
        System.out.println("coucoutavu");
    }

// méthode obligatoire d'add listener
    @Override
    public void actionPerformed(ActionEvent e) {
    }

/*
    public static   JPanel buildEx1Content(){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");
        container.add(boutonRetour);

        //   boutonRetour.addActionListener(UserWindows);
        return container;
    }
  */


// rouvre la page d'accueil
    public void retourHome(ActionEvent e) {
       this.setContentPane(buildAccueilContent(this) );
    }




    }

