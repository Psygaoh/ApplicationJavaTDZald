package GUI;

import Application.Devinette;

import javax.swing.*;
import java.awt.*;

public class DevinetteWindows {
    private static String answer = "";

    public DevinetteWindows(){}

    public DevinetteWindows(UserWindows userWindows) {
        DevinetteWindows devinetteWindows = new DevinetteWindows();
        Devinette devinette = new Devinette();
        answer = devinette.getReponse();
        windowsExercice2(userWindows);
    }


    private void windowsExercice2(UserWindows userWindows){
        userWindows.setTitle("Exercice 2");
        userWindows.setContentPane(buildEx2Content(userWindows));

        userWindows.setVisible(true);

    }


    public static JPanel buildEx2Content(UserWindows userWindows){

        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");

        JPanel panelTitre = new JPanel();
        JPanel panelContenuMargin = new JPanel();
        JPanel panelContenu = new JPanel();
        JPanel espace = new JPanel();
        JPanel espaceH = new JPanel();
        JLabel labelTitre = new JLabel("Exercice 2");
        JLabel labelReponse = new JLabel(getAnswer());



        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelContenu);

        panelTitre.add(boutonRetour);
        panelTitre.add(labelTitre);

        panelContenu.add(labelReponse);


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

    public static String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
