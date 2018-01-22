import Application.Concession.Assurance;
import Application.Concession.Seller;
import Application.Concession.User;
import Application.Devinette;
import Application.HelloWorld;
import GUI.UserWindows;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

      //  Devinette devinette = new Devinette();
      //  devinette.comparer();
        User user1 = new User("Hachi","password","Hunter","Dwayne","Homme", 25, 3156789);
        Seller seller1 = new Seller("Johnson","Callaway","Mark","Homme", 46);

// create catalogue produit
        Assurance[] arrayAssurance = new Assurance[5] ;

        // create Produit
        Assurance toutRisque = new Assurance("Assurance Tout Risque", "Couvre tout les cas possibles", 27);
        arrayAssurance[0] = toutRisque;

        seller1.addVehicule("F1", "ça roule sur la terre", 50000, "Ferrari", 1, "voiture");
        seller1.addVehicule("CALIDUS 914", "ça vole dans les airs", 60000, " AUTOGYRO",  6, "avion");
        seller1.addVehicule("Fiesta","la nouvelle ford",6990,"Ford",4,"voiture");
        seller1.addVehicule("Stormseeker","STORM INCOMING",3333333,"METAL",4,"voiture");
        seller1.addAssurance("Crash","tu te mange un arbre? t'es couvert", 15);
        seller1.addAssurance("Vol","t'es pas un oiseau, et on te chourre ta caisse", 20);
        seller1.addAssurance("Décès","t'es mort? alors pour ta famille prend ça", 40);


        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UserWindows userWindows = new UserWindows();
            }
        });


    }
}
