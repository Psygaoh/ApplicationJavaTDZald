package Application.Concession;

public class Produit {

    // attributs
    protected int prix;
    protected String description;
    protected String nom;
    protected int nbProduit;
    protected String type;
    public int duree;
    protected String marque;
    int nbVehicule;

    // constructeurs

    public Produit(){
        nbProduit++;
    };

    public Produit(String pNom, String pDescri, int pPrix, String pType){
        nom = pNom;
        description = pDescri;
        prix = pPrix;
        type = pType;
        nbProduit++;

    };


    // setters


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbProduit(int nbProduit) {
        this.nbProduit = nbProduit;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    // getters
    public String getNom() {
        return nom;
    }

    public int getNbProduit() {
        return nbProduit;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
    // autres

    }

