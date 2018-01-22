package Application.Concession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Assurance extends Produit {
        // attributs

   protected String dateSouscription;
   int nbAssurance;

// constructeur

    public Assurance (String pNom, String pDescri, int pPrix){
        super();
        this.nom = pNom;
        this.description = pDescri;
        this.prix = pPrix;
        this.type = "assurance";
        nbAssurance++;
        dateSouscrip();
      //  System.out.println("Un nouveau produit a été ajouté ! c'est une Assurance du nom de: "+this.nom);
    };

    // setters
    // getters

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbAssurance() {
        return nbAssurance;
    }

    public void setNbAssurance(int nbAssurance) {
        this.nbAssurance = nbAssurance;
    }

    public void dateSouscrip() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Calendar calobj = Calendar.getInstance();
        this.dateSouscription= df.format(calobj.getTime());
    }


    //autres






}


