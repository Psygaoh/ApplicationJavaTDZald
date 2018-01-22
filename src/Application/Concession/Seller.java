package Application.Concession;

public class Seller extends Account {
    // attributs
    protected int matricule = 200000;
    protected int nbVentes = 0;
    protected int nbCarAjout = 0;
    protected int nbAssuAjout = 0;
    public Vehicule[] arrayVehicule = new Vehicule[15];
    public Assurance[] arrayAssurance = new Assurance[15];

    // constructeur


    public Seller() {
    }

    public Seller (String pUsername, String pNom, String pPrenom, String pGenre, int pAge){
        super();
        this.matricule ++;
        this.username=pUsername;
        this.nom = pNom;
        this.prenom = pPrenom;
        this.genre = pGenre;
        this.age = pAge;
        System.out.println("\t Nouveau vendeur créé sous le pseudo : "+this.username);
    };


    // setters

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    // getters

    public int getMatricule() {
        return matricule;
    }

    public int getNbCarAjout() {
        return nbCarAjout;
    }

    public int getNbAssuAjout() {
        return nbAssuAjout;
    }

    public Vehicule[] getArrayVehicule() {
        return arrayVehicule;
    }
// autres

    @Override
    public String idYourself() {
        return "\t Matricule: "+this.matricule+" "+ super.idYourself();
    }


    public void editFacture(Produit produit, Seller seller, User user){
        int nbFact = Facture.getNbFacture();
        Facture facture1 = new Facture(produit,seller,user);
    };
// les deux prochaines méthodes permettent d'ajouter de sproduits
    public void addVehicule(String pNom, String pDescri, int pPrix, String pMarque, int pPlace, String pType){
        Vehicule nouveauVehi = new Vehicule(pNom, pDescri,pPrix,pMarque,pPlace,pType);
        int i = nbCarAjout;
        arrayVehicule[i] = nouveauVehi;
        nbCarAjout++;
    }

    public void addAssurance (String pNom, String pDescri, int pPrix){
        Assurance nouvAssurance = new Assurance(pNom, pDescri,pPrix);
        int i = nbAssuAjout;
        arrayAssurance[i] = nouvAssurance;
        nbAssuAjout++;
    }

    }


