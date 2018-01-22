package Application.Concession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Facture {
    // attributs
    int numFacture = 300000;
    int prix;
    String nomClient;
    int numClient;
    int numVendeur;
    String type;
    String nomVendeur;
    String nomProduit;
    String descriptProduit;
    String dateFacture;
    String marque;
    public static int nbFacture = 0;


// variables pour text dynamique
    String result ="";
    String surLaDuree = "";

    // constructeur


    public Facture(Produit item, Seller seller, User buyer) {
        this.numFacture = numFacture++;
        this.nomClient = buyer.getNom();
        this.numClient = buyer.getNumClient();
        this.numVendeur = seller.getMatricule();
        this.nomVendeur = seller.getNom();
        this.nomProduit = item.getNom();
        this.prix = item.getPrix();
        this.descriptProduit = item.getDescription();
        this.type = item.type;
        this.marque=item.marque;
        nbFacture++;
        this.calcDateFacture();
        this.afficherFacture();
        }



    // GETTERS / SETTERS



    public void setDateFacture(String dateFacture) {
        this.dateFacture = dateFacture;
    }


    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public int getNumVendeur() {
        return numVendeur;
    }

    public void setNumVendeur(int numVendeur) {
        this.numVendeur = numVendeur;
    }

    public String getNomVendeur() {
        return nomVendeur;
    }

    public void setNomVendeur(String nomVendeur) {
        this.nomVendeur = nomVendeur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptProduit() {
        return descriptProduit;
    }

    public void setDescriptProduit(String descriptProduit) {
        this.descriptProduit = descriptProduit;
    }

    public String getDateFacture() {
        return dateFacture;
    }

    static public int getNbFacture() {
        return nbFacture;
    }

    public void setNbFacture(int nbFacture) {
        this.nbFacture = nbFacture;
    }

    // autres

    public void calcDateFacture() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Calendar calobj = Calendar.getInstance();
        this.dateFacture= df.format(calobj.getTime());
    }

    public void afficherFacture(){
        unUne();
        surLaDuree();
        System.out.println("Welcome "+this.nomClient+" to ¤ U'DEVinitely need a new locomotion! ¤");
        System.out.println("*******¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤***********");
        System.out.println("Nous sommes heureux de vois avoir reçu le: "+this.dateFacture);
        System.out.println("*******¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤¤******");
        System.out.println("Vous avez été accueilli par '"+this.nomVendeur+"' pour un achat "+result+" "+this.type);

        if (this.type=="voiture" || this.type == "avion"){                                  // boucle pour completer selon le type
            System.out.println("modèle: "+this.nomProduit+" de la marque: "+this.marque);
          };
        System.out.println("Le montant à payer est de "+this.prix+"euros "+surLaDuree);
        System.out.println("Pour rappel, voici la description de votre achat "+this.descriptProduit);
        System.out.println("*******************************************");
        System.out.println("De plus, nos assurances ne sont disponible que pour une durée de 3 ans, renouvelable d'un simple appel");
        System.out.println("*******************************************");
        System.out.println("Au plaisir de vous revoir!");

    }

    public void unUne(){
        if (this.type == "assurance"|| this.type=="voiture"){result="d'une";}
            else result="d'un";
    }
    public void surLaDuree(){
        if (this.type=="assurance"){surLaDuree = " par mois pendant 36 mois";};
    }

// fin classe
}
