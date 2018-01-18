package GUI;

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
// créer la fenetre de départ
    public UserWindows() {
        super();
        setUp();
    }
// test ???

/*
    public UserWindows(String exercice){
        super();
        if (exercice == "exercice 1"){
            exercice1();
        }
            else {exercice2();
        }
    }
    */

// fonction exercice 1; appelle helloWorld dans une nouvelle fenetre
    private void exercice1() {
       HelloWorld helloWorld = new HelloWorld(this);
       /* setTitle("Exercice 1");
        setSize(1100, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        */
    }

// exercice 2
    private void exercice2() {
        setTitle("Exercice 2");
        setSize(1100, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // constructeur de la fenetre de base
    private void setUp() {
        setTitle("Mon application");
        setSize(1100, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(buildPanelContent());
        this.setVisible(true);
    }


    // contenu de la fenetre de base
    private JPanel buildPanelContent() {
        // Ressources

        // creations
        JPanel container = new JPanel();
        JPanel panelTitre = new JPanel();
        JPanel panelContenuMargin = new JPanel();
        JPanel panelContenu = new JPanel();
        JPanel espace = new JPanel();
        JPanel espaceH = new JPanel();


        JLabel label_1 = new JLabel("welcome");
        JButton bouton_1 = new JButton("essai");
        JButton bouton_2 = new JButton("essai2");
        JButton bouton_3 = new JButton("essai3");
        JButton bouton_4 = new JButton("essai4");
        // parametres

        //du jlabel bienvenu
        label_1.setFont(new Font("Serif", Font.BOLD, 40));

        // du panel
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        //   panelTitre.setLayout(new BoxLayout(panelTitre,BoxLayout.LINE_AXIS) );
        // panelContenuMargin(new BorderLayout());
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
        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelContenu);
       // panelContenuMargin.add(espace);

        panelTitre.add(label_1);

        panelContenu.add(bouton_1);
        panelContenu.add(bouton_2);
        panelContenu.add(bouton_3);
        panelContenu.add(bouton_4);

        // listeners
        bouton_1.addActionListener(this::helloWorld);
        bouton_2.addActionListener(this::actionPerformed1);
        // return
        return container;

    }



    public void helloWorld(ActionEvent e) {
      //  exercice1();
       // System.out.println("coucou message 1");
        HelloWorld helloWorld = new HelloWorld(this);
       // System.out.println(helloWorld.getTexte());
    }
    public void actionPerformed1(ActionEvent e) {
        System.out.println("coucoutavu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // methodes autres




    }

