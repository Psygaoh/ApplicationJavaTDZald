package GUI;

import Application.Devinette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevinetteWindows extends Devinette implements ActionListener{
// les variables
    private static String answer = "";
    private static Devinette devinette = new Devinette();
    private static int input = 0;
// elements du GUI demandant une création à l'avance
    private static JLabel labelReponse = new JLabel(getAnswer());
    private static JTextField inputUser = new JTextField(3);

// constructeurs
    public DevinetteWindows(){}

    public DevinetteWindows(UserWindows userWindows) {
       // DevinetteWindows devinetteWindows = new DevinetteWindows();
        windowsExercice2(userWindows);
    }

// créé la fenetre
    private void windowsExercice2(UserWindows userWindows){
        userWindows.setTitle("Exercice 2");
        userWindows.setContentPane(buildEx2Content(userWindows));

        userWindows.setVisible(true);

    }

// créé le contenu de la fenetre
    public static JPanel buildEx2Content(UserWindows userWindows){

      //  Devinette devinette = new Devinette();
        answer = devinette.getReponse();


        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");

        JPanel panelTitre = new JPanel();
        JPanel panelContenuMargin = new JPanel();
        JPanel panelContenu = new JPanel();
        JPanel panelBoutonAlig = new JPanel();
        JPanel espace = new JPanel();
        JPanel espaceH = new JPanel();
        JLabel labelTitre = new JLabel("Exercice 2");

        JLabel labelConsigne = new JLabel("Quel nombre vas tu essayer?");

        JButton boutonGO = new JButton("GO !");
        JButton boutonAgain = new JButton("On recommence?");

        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelContenu);

        panelTitre.add(boutonRetour);
        panelTitre.add(labelTitre);


        panelContenu.add(labelConsigne);
        panelContenu.add(inputUser);
        panelContenu.add(labelReponse);
        panelContenu.add(panelBoutonAlig);

        panelBoutonAlig.add(boutonAgain);
        panelBoutonAlig.add(boutonGO);


        labelTitre.setFont(new Font("Serif", Font.BOLD, 40));

        // du panel
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        panelContenu.setLayout(new GridLayout(4, 2, 20, 30));
        panelBoutonAlig.setLayout(new GridLayout(1, 2, 0, 30));


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

        labelConsigne.setPreferredSize(new Dimension(600,60));
        inputUser.setPreferredSize(new Dimension(300,150));
        inputUser.setText("Entrez un chiffre");
        // du bouton

        // param du formattedtext




        boutonRetour.addActionListener(userWindows::retourHome);
        boutonGO.addActionListener(DevinetteWindows::devinetteGo);
        boutonAgain.addActionListener(DevinetteWindows::devinetteNew);
        inputUser.addActionListener(DevinetteWindows::devinetteGo);



        return container;
    }

    // créé une nouvelle devinette et remet les champs a ZERO
    private static void devinetteNew(ActionEvent actionEvent) {
        Devinette devinette = new Devinette();
        inputUser.setText("Entrez un chiffre");
        labelReponse.setText("");
    }

// va vérifier si la valeur de input est un entier, et retournera true or false
    public static boolean isInteger(JTextField inputUser) {
        try {
            Integer.valueOf(inputUser.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

// run la devinette
    private static void devinetteGo(ActionEvent actionEvent) {
     //   System.out.println("on click devinette Go "+DevinetteWindows.devinette.getInput());
        if (inputUser != null ) {                   // vérifie qu'il y'ai bien un input

                if( isInteger(inputUser) == true){          // si c'est parsable
                   devinette.setInput(Integer.parseInt(inputUser.getText()));
               //     System.out.println("input manuel? " + devinette.getInput());
                    Devinette.comparer();
                    labelReponse.setText(devinette.getReponse());
                }
                else{
                labelReponse.setText("Attention, il faut entrer un chiffre");
                }
        }else {labelReponse.setText("Merci de remplir le champ");
              }

    }





    // getters setters
    public static void setLabelReponse(JLabel labelReponse) {
        DevinetteWindows.labelReponse = labelReponse;
    }

    public static JLabel getLabelReponse() {
        return labelReponse;
    }


    public static String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDevinette(Devinette devinette) {
        this.devinette = devinette;
    }

    public Devinette getDevinette() {
        return devinette;
    }



    public static JTextField getInputUser() {
        return inputUser;
    }

    public static void setInputUser(JTextField inputUser) {
        DevinetteWindows.inputUser = inputUser;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
