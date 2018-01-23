package GUI;
import Application.Concession.*;
import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

// Cette fenetre à de grooooooos problème au niveau de l'organisation
// il faudrait mieux organiser les différents composants;
// j'ai fait l'erreur depuis le début de créer les composants du GUI
// dans les méthodes, au lieux de les déclarer en variables; le reprendre prendrait
// trop de temps.
// La concession rencontre un problème au niveau du retour à l'accueil qui ne reset pas
// la mise ne page.

public class ConcessionWindows implements ActionListener {
   // les variables de classes
    private static String username;
    protected static String password;
    private static User userActif = new User();
    Seller sellerActif = new Seller();



    // les elements du GUI avec des valeurs;
    // requiert d'être déclaré avant de les set
    private static JPanel container = new JPanel();

    private static JPanel panelContenu = new JPanel();
    private static JButton boutonRetour = new JButton("retour");

    private static JPanel panelTitre = new JPanel();
    private static JPanel panelContenuMargin = new JPanel();
    private static JPanel panelBoutonAlig = new JPanel();
    private static JPanel espace = new JPanel();
    private static JPanel espaceH = new JPanel();
    private static  JLabel labelTitre = new JLabel("Concession. WORK IN PROGRESS");
    private static  JPanel panelMenu = new JPanel();

    static JTextField usernameField = new JTextField("username");
    static JTextField passwordField = new JTextField();         // oui, il ne s'agit que d'un textfield, et pas d'un passwordfield
                                                            // non ce n'est absolument pas sécurisé.
    static JButton closePopup = new JButton("ENTRER");
    static JLabel usernameActif = new JLabel();


    static JDialog dialog = new JDialog();


    // pour afficheruser, les champs text;
    private static JTextField textFieldUsername = new JTextField(userActif.getUsername());
    private static JTextField textFieldnumCarte = new JTextField(String.valueOf(userActif.getNumCarte() ),3);
    private static JTextField textFieldNom = new JTextField(userActif.getNom(),3);
    private static JTextField textFieldPrenom = new JTextField(userActif.getPrenom(),3);
    private static JTextField textFieldGenre = new JTextField(userActif.getGenre(),3);
    private static JTextField textFieldAge = new JTextField(String.valueOf(userActif.getAge() ),3);



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

        usernameActif.setText("Bienvenue "+userActif.getUsername());
        dialog.dispose();
    }

    // set le contenu de la jframe userWindows
    public static JPanel buildConcessionContent(UserWindows userWindows){
        //  Devinette devinette = new Devinette();


        JButton boutonAfficherUser = new JButton("Afficher User");
        JButton boutonParcourirCatalogue = new JButton("Catalogue");
        container.add(panelTitre);
        container.add(panelContenuMargin);
        panelContenuMargin.add(espaceH);
        panelContenuMargin.add(panelMenu);
        panelContenuMargin.add(panelContenu);

        panelTitre.add(boutonRetour);
        panelTitre.add(labelTitre);


       //  panelContenu.add(panelBoutonAlig);



        labelTitre.setFont(new Font("Serif", Font.BOLD, 40));

        // du panel
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        panelMenu.setLayout(new BorderLayout());
        panelContenu.setLayout(new BoxLayout(panelContenu,BoxLayout.PAGE_AXIS));

       // panelContenu.setLayout(new GridLayout(4, 2, 20, 30));
        panelBoutonAlig.setLayout(new GridLayout(1, 2, 0, 30));


        // les couleurs
        panelMenu.setBackground(Color.YELLOW);
        panelTitre.setBackground(Color.CYAN);
        panelContenuMargin.setBackground(Color.LIGHT_GRAY);
        espace.setBackground(Color.LIGHT_GRAY);
        espaceH.setBackground(Color.LIGHT_GRAY);
        panelContenu.setBackground(Color.PINK);

        panelMenu.add(usernameActif,BorderLayout.LINE_START);
        panelMenu.add(boutonAfficherUser,BorderLayout.LINE_END);
        panelMenu.add(boutonParcourirCatalogue,BorderLayout.CENTER);

        // la taille
        panelContenu.setPreferredSize(new Dimension(800, 540));
        panelMenu.setPreferredSize(new Dimension(800,100));
        espaceH.setPreferredSize(new Dimension(1200,10));
        espace.setPreferredSize(new Dimension(1200,15));


        // param du formattedtext




        boutonRetour.addActionListener(userWindows::retourHome);
        boutonAfficherUser.addActionListener(ConcessionWindows::afficherUser);
        boutonParcourirCatalogue.addActionListener(ConcessionWindows::catalogue);



        return container;
    }

    private static void catalogue(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null,
                "WORK IN PROGRESS; FONCTION NON DISPONIBLE");

    }

    private static void afficherUser(ActionEvent actionEvent) {
        ConcessionWindows.panelContenu.setVisible(false);
        JPanel panelContenuUser = new JPanel();

        // les étiquettes
        JLabel labelUserName = new JLabel("UserName :");
        JLabel labelNumCarte = new JLabel("Num CB:");
        JLabel labelNom = new JLabel("Nom :" );
        JLabel labelPrenom = new JLabel("Prenom :");
        JLabel labelGenre = new JLabel("Genre :");
        JLabel labelAge = new JLabel("Age :");
        JLabel labelPassword = new JLabel("password :");

        // le bouton valider
        JButton valider = new JButton("valider");



        panelContenuMargin.add(panelContenuUser);
// add au contenuUser

        panelContenuUser.add(labelUserName);
        panelContenuUser.add(textFieldUsername);
        panelContenuUser.add(labelNom);
        panelContenuUser.add(textFieldNom);
        panelContenuUser.add(labelPrenom);
        panelContenuUser.add(textFieldPrenom);
        panelContenuUser.add(labelAge);
        panelContenuUser.add(textFieldAge);
        panelContenuUser.add(labelGenre);
        panelContenuUser.add(textFieldGenre);
        panelContenuUser.add(labelNumCarte);
        panelContenuUser.add(textFieldnumCarte);

        panelContenuUser.add(valider);

        panelContenuUser.setPreferredSize(new Dimension(800, 540));
        textFieldUsername.setPreferredSize(new Dimension(75,25));
        textFieldNom.setPreferredSize(new Dimension(75,25));
        textFieldPrenom.setPreferredSize(new Dimension(75,25));
        textFieldGenre.setPreferredSize(new Dimension(75,25));
        textFieldAge.setPreferredSize(new Dimension(75,25));
        textFieldnumCarte.setPreferredSize(new Dimension(75,25));



        panelContenuUser.setBackground(Color.red);
        valider.addActionListener(ConcessionWindows::validerUser);
    }

    private static void validerUser(ActionEvent actionEvent) {
        userActif.setUsername(textFieldUsername.getText());
        userActif.setNom(textFieldNom.getText());
        userActif.setPrenom(textFieldPrenom.getText());
        userActif.setNumCarte(Long.parseLong(textFieldnumCarte.getText() ) );
        userActif.setAge(Integer.parseInt(textFieldAge.getText()));
        userActif.setGenre(textFieldGenre.getText());
        JOptionPane.showMessageDialog(null, "Utilisateur actif modifié");
        System.out.println(userActif.idYourself());
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


    public static User getUserActif() {
        return userActif;
    }

    public static void setUserActif(User userActif) {
        ConcessionWindows.userActif = userActif;
    }

    public Seller getSellerActif() {
        return sellerActif;
    }

    public void setSellerActif(Seller sellerActif) {
        this.sellerActif = sellerActif;
    }

    public static JPanel getPanelContenu() {
        return panelContenu;
    }

    public static void setPanelContenu(JPanel panelContenu) {
        ConcessionWindows.panelContenu = panelContenu;
    }


    public static JTextField getPasswordField() {
        return passwordField;
    }

    public static void setPasswordField(JTextField passwordField) {
        ConcessionWindows.passwordField = passwordField;
    }

    public static JLabel getUsernameActif() {
        return usernameActif;
    }

    public static void setUsernameActif(JLabel usernameActif) {
        ConcessionWindows.usernameActif = usernameActif;
    }

    public static JDialog getDialog() {
        return dialog;
    }

    public static void setDialog(JDialog dialog) {
        ConcessionWindows.dialog = dialog;
    }

    // le pré requis pour l'action listener
    @Override
    public void actionPerformed(ActionEvent e) {


    }



}
