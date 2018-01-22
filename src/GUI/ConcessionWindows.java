package GUI;
import Application.Concession.*;

import javax.swing.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;


public class ConcessionWindows implements ActionListener {
   // les variables de classes
    private static String username;
    protected static String password;
    private static User userActif = new User();



    // les elements du GUI avec des valeurs;
    // requiert d'être déclaré avant de les set

    static JTextField usernameField = new JTextField("username");
    static JTextField passwordField = new JTextField();         // oui, il ne s'agit que d'un textfield, et pas d'un passwordfield
                                                            // non ce n'est absolument pas sécurisé.
    static JButton closePopup = new JButton("ENTRER");
    static JLabel usernameActif = new JLabel();

    static JDialog dialog = new JDialog();


// le constructeur
    public ConcessionWindows(UserWindows userWindows) {

        username = "test";
        password = "password";
        setUser(userWindows);
        windowsConcession(userWindows);


    }

//set les parametres basiques de la fenetre
    private void windowsConcession(UserWindows userWindows){
        userWindows.setTitle("Concession");
        userWindows.setContentPane(buildConcessionContent(userWindows));
        userWindows.setVisible(true);

    }

    // créé une fenetre modale pour selectionner l'username;
    // et créer un objet User correspondant

    public void setUser(UserWindows userWindows){



        dialog.setTitle("Home");
        dialog.setSize(500, 300);
        dialog.setResizable(false);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);

        JPanel panelModal = new JPanel();
        JLabel labelName = new JLabel("username");
        JLabel labelPw = new JLabel("password");


        dialog.add(panelModal);
        panelModal.add(labelName);
        panelModal.add(usernameField);
        panelModal.add(labelPw);
        panelModal.add(passwordField);
        panelModal.add(closePopup);

        closePopup.addActionListener(ConcessionWindows::closePopUp);
        closePopup.addActionListener(this);


        panelModal.setLayout(new GridLayout(4, 2, 20, 30));
        closePopup.setPreferredSize(new Dimension(100,40));
        panelModal.setPreferredSize(new Dimension(800, 100));
       // panelModal2.setPreferredSize(new Dimension(1200,200));

     //   dialog.pack();
        dialog.setVisible(true);
    }


    // la fonction sur le bouton entrer de al pop up;
    // ferme la dites pop-up; et lance la création de l'user

    private static void closePopUp(ActionEvent actionEvent) {
        userActif.setUsername(usernameField.getText());
        userActif.setPassword(passwordField.getText());

        usernameActif.setText("Bienvenu "+userActif.getUsername());
        dialog.dispose();
    }

    // set le contenu de la jframe userWindows
    public static JPanel buildConcessionContent(UserWindows userWindows){
        //  Devinette devinette = new Devinette();
        JPanel container = new JPanel();
        JButton boutonRetour = new JButton("retour");

        JPanel panelTitre = new JPanel();
        JPanel panelContenuMargin = new JPanel();
        JPanel panelContenu = new JPanel();
        JPanel panelBoutonAlig = new JPanel();
        JPanel espace = new JPanel();
        JPanel espaceH = new JPanel();
        JLabel labelTitre = new JLabel("Concession. WORK IN PROGRESS");

        JButton boutonAfficherUser = new JButton("Afficher User");

        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelContenu);

        panelTitre.add(boutonRetour);
        panelTitre.add(labelTitre);

        panelContenu.add(usernameActif);
        panelContenu.add(boutonAfficherUser);
        panelContenu.add(panelBoutonAlig);



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


        // param du formattedtext




        boutonRetour.addActionListener(userWindows::retourHome);
        boutonAfficherUser.addActionListener(ConcessionWindows::afficherUser);



        return container;
    }

    private static void afficherUser(ActionEvent actionEvent) {
        Seller seller1 = new Seller();
        System.out.println(userActif.idYourself());
        userActif.parcourirCatalogVehicule(seller1);
    }


// les getters / setters

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ConcessionWindows.username = username;
    }



    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ConcessionWindows.password = password;
    }



    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }



    public JButton getClosePopup() {
        return closePopup;
    }

    public void setClosePopup(JButton closePopup) {
        this.closePopup = closePopup;
    }

// le pré requis pour l'action listener
    @Override
    public void actionPerformed(ActionEvent e) {


    }



}
