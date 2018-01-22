package Application.Concession;

public class Vehicule extends Produit {
    // attributs
    protected int place;
    protected int reservoir = 100;
    int nbVehicule;

    // constructeur
    public Vehicule (String pNom, String pDescri, int pPrix, String pMarque, int pPlace, String pType){
        super();
        marque = pMarque;
        place = pPlace;
        this.nom = pNom;
        this.description = pDescri;
        this.prix = pPrix;
        this.type = pType;
        nbVehicule++;

       // System.out.println("Un nouveau produit a été ajouté ! c'est un véhicule du nom de: "+this.nom);

    }

    // setters

    public void setType(String type) {
        this.type = type;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    // getters

    public int getNbVehicule() {
        return nbVehicule;
    }

    public int getPlace() {
        return place;
    }

    public String getType() {
        return type;
    }

    public String getMarque() {
        return marque;
    }

    public int getReservoir() {
        return reservoir;
    }

    @Override
    public int getPrix() {
        return super.getPrix();
    }
    //autres

}
